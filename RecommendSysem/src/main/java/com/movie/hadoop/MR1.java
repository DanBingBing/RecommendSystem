package com.movie.hadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.junit.Test;

/**
 * 
 * 将item profile转置
 */
public class MR1 {
	private static String inputPath = "/context/step1_input";
	private static String outputPath = "/context/step1_output";
	private static String hdfs = "hdfs://127.0.0.1:9000";

	public int run() {
		try {
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", hdfs);
			Job job = Job.getInstance(conf, "step1");

			// 运行 MR1 类
			job.setJarByClass(MR1.class);

			// 设置 map
			job.setMapperClass(Mapper1.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);

			// 设置 reduce
			job.setReducerClass(Reducer1.class);
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

			// 提交 job 并返回成功或失败的结果
			return job.waitForCompletion(true) ? 1 : -1;
		} catch (ClassNotFoundException | InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void step1() throws IOException, ClassNotFoundException, InterruptedException {
		int result = -1;
		result = new MR1().run();
		if (result == 1) {
			System.out.println("step1运行成功");
			
			MR2.step2();
		} else if (result == -1) {
			System.out.println("step1运行失败");
		}
	}
}