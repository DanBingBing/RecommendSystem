package com.movie.hadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.junit.Test;

/**
 * 
 * 将item profile转置
 */
public class MR1 extends TextOutputFormat{
	//private static String inputPath = "/context/step1_input/";
	//private static String outputPath = "/context/step1_output";
	//private static String hdfs = "hdfs://127.0.0.1:9000";
	
	// 重写输出文件命名方法，不然生成的所有文件都是一个名字
	protected static void setPutputName(JobContext job,String name) {
		job.getConfiguration().set(BASE_OUTPUT_NAME, name);
	}

	public int run(Integer uId, String hdfsUrl, String inputPath, String resultFilePath, String resultFilename) {
		try {
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", hdfsUrl);
			Job job = Job.getInstance(conf, "step1");

			// 运行 MR1 类
			job.setJarByClass(MR1.class);
			// 设置生成文件的名字
			MR1.setPutputName(job, resultFilename);
			
			// 设置 map
			job.setMapperClass(Mapper1.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);

			// 设置 reduce
			job.setReducerClass(Reducer1.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);

			FileSystem fs = FileSystem.get(conf);
			Path inpath = new Path(inputPath+"ItemProfile_"+uId+".txt");
			if (fs.exists(inpath)) {
				FileInputFormat.addInputPath(job, inpath);
				System.out.println("文件读取成功！");
			} else {
				System.out.println(inpath);
				System.out.println("路径不存在！");
			}

			Path outpath = new Path(resultFilePath);
			fs.delete(outpath, true);
			FileOutputFormat.setOutputPath(job, outpath);

			// 提交 job 并返回成功或失败的结果
			return job.waitForCompletion(true) ? 1 : -1;
		} catch (ClassNotFoundException | InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void step1(Integer uId, String hdfsUrl, String inputPath, String resultFilePath, String resultFilename) throws IOException, ClassNotFoundException, InterruptedException {
		int result = -1;
		result = new MR1().run(uId,hdfsUrl,inputPath,resultFilePath,resultFilename);
		if (result == 1) {
			System.out.println("step1运行成功");
		} else if (result == -1) {
			System.out.println("step1运行失败");
		}
	}
}