package com.movie.hadoop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * item user (评分矩阵) X item profile（已转置）
 */
public class MR2 {
	private static String inputPath = "/context/step2_input";
	private static String outputPath = "/context/step2_output";
	// 将step1中输出的转置矩阵作为全局缓存
	private static String cache = "/context/step1_output/part-r-00000";

	private static String hdfs = "hdfs://127.0.0.1:9000";

	public int run() {
		try {
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", hdfs);
			Job job = Job.getInstance(conf, "step2");
			// 如果未开启,使用 FileSystem.enableSymlinks()方法来开启符号连接。
			FileSystem.enableSymlinks();
			// 要使用符号连接，需要检查是否启用了符号连接
			boolean areSymlinksEnabled = FileSystem.areSymlinksEnabled();
			System.out.println(areSymlinksEnabled);
			// 添加分布式缓存文件
			job.addCacheArchive(new URI(cache + "#itemUserScore1"));

			// 运行 MR2 类
			job.setJarByClass(MR2.class);
			
			// 配置任务map和reduce类
			job.setMapperClass(Mapper2.class);
			job.setReducerClass(Reducer2.class);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);

			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);

			FileSystem fs = FileSystem.get(conf);
			Path inpath = new Path(inputPath);
			if (fs.exists(inpath)) {
				FileInputFormat.addInputPath(job, inpath);
			} else {
				System.out.println(inpath);
				System.out.println("不存在");
			}

			Path outpath = new Path(outputPath);
			fs.delete(outpath, true);
			FileOutputFormat.setOutputPath(job, outpath);

			return job.waitForCompletion(true) ? 1 : -1;
		} catch (ClassNotFoundException | InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void step2() throws IOException, ClassNotFoundException, InterruptedException {
		int result = -1;
		result = new MR2().run();
		if (result == 1) {
			System.out.println("step2运行成功");
			// 开始第三步
			MR3.step3();
		} else if (result == -1) {
			System.out.println("step2运行失败");
		}
	}
}