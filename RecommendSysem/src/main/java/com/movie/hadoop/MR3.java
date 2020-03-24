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
 * cos<步骤1输入,步骤2输出>
 */
public class MR3 {
	private static String inputPath = "/context/step1_input";
	private static String outputPath = "/context/step3_output";
	// 将step1中输出的转置矩阵作为全局缓存
	private static String cache = "/context/step2_output/part-r-00000";

	private static String hdfs = "hdfs://127.0.0.1:9000";

	public int run() {
		try {
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", hdfs);
			Job job = Job.getInstance(conf, "step3");
			// 如果未开启,使用 FileSystem.enableSymlinks()方法来开启符号连接。
			FileSystem.enableSymlinks();
			// 要使用符号连接，需要检查是否启用了符号连接
			boolean areSymlinksEnabled = FileSystem.areSymlinksEnabled();
			System.out.println(areSymlinksEnabled);
			// 添加分布式缓存文件
			job.addCacheArchive(new URI(cache + "#itemUserScore2"));

			// 运行 MR3 类
			job.setJarByClass(MR3.class);
			
			// 配置任务map和reduce类
			job.setMapperClass(Mapper3.class);
			job.setReducerClass(Reducer3.class);

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

	public static void step3() throws IOException, ClassNotFoundException, InterruptedException {
		int result = -1;
		result = new MR3().run();
		if (result == 1) {
			System.out.println("step3运行成功");
		} else if (result == -1) {
			System.out.println("step3运行失败");
		}
	}
}
