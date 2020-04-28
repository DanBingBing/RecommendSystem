package com.movie.hadoop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * cos<步骤1输入,步骤2输出>
 */
public class MR3 extends TextOutputFormat{
	//private static String inputPath = "/context/step1_input/";
	//private static String outputPath = "/context/step3_output";
	// 将step1中输出的转置矩阵作为全局缓存
	//private static String cache;

	//private static String hdfs = "hdfs://127.0.0.1:9000";
	
	// 重写输出文件命名方法
	protected static void setPutputName(JobContext job,String name) {
		job.getConfiguration().set(BASE_OUTPUT_NAME, name);
	}

	public int run(Integer uId, String hdfsUrl, String inputPath, String resultFilePath,String resultFilename, String cachePath) {
		try {
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", hdfsUrl);
			Job job = Job.getInstance(conf, "step3");
			// 如果未开启,使用 FileSystem.enableSymlinks()方法来开启符号连接。
			FileSystem.enableSymlinks();
			// 要使用符号连接，需要检查是否启用了符号连接
			boolean areSymlinksEnabled = FileSystem.areSymlinksEnabled();
			System.out.println(areSymlinksEnabled);
			// 添加分布式缓存文件
			job.addCacheArchive(new URI(cachePath + "#itemUserScore2"));

			// 配置任务map和reduce类
			job.setJarByClass(MR3.class);
			// 设置生成文件的名字
			MR3.setPutputName(job, resultFilename);

			job.setMapperClass(Mapper3.class);
			job.setReducerClass(Reducer3.class);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);

			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			
			FileSystem fs = FileSystem.get(conf);
			
			// 先构建一个路径
			Path inpath = new Path(inputPath+"/"+"ItemProfile_"+uId+".txt");
			
			if (fs.exists(inpath)) {
				FileInputFormat.addInputPath(job, inpath);
			} else {
				System.out.println(inpath);
				System.out.println("不存在");
			}

			Path outpath = new Path(resultFilePath);
			// 不删除文件路径,重新创建新路径
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

	public static void step3(Integer uId, String hdfsUrl, String inputPath, String resultFilePath, String resultFilename, String cachePath) throws IOException, ClassNotFoundException, InterruptedException {
		// 先为step2中生成的全局缓存文件命名赋值给变量，方便读取使用
		//cache = "/context/step2_output/"+cacheName;
		//cache = "/context/step2_output/"+cacheName;
				
		int result = -1;
		result = new MR3().run(uId,hdfsUrl,inputPath,resultFilePath,resultFilename,cachePath);
		if (result == 1) {
			System.out.println("step3运行成功");
		} else if (result == -1) {
			System.out.println("step3运行失败");
		}
	}
	
}
