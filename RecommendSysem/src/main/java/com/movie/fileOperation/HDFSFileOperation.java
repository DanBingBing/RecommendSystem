package com.movie.fileOperation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class HDFSFileOperation {
	
	public static void uploadFile(String uploadPath,String filename) throws Exception {
		// 获取当前项目的路径
		String path = System.getProperty("user.dir");
		
		// 本地文件的目录
		String localSrc = path +"/userFiles/"+filename;
		//System.out.println(localSrc);
		
		// HDFS 不能在上传文件时的文件名相同,这里已经底层实现了，可以重复操作
		String dst = uploadPath+filename;
		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		// 连接 HDFS 文件系统
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(dst), conf);
		FSDataOutputStream out = fs.create(new Path(dst));
		IOUtils.copyBytes(in, out, 4096, true);
		System.out.println("上传 "+filename+" 成功!");
	}

	public static void downloadFile(String downloadPath,String filename,String rselutFilename) throws Exception {
		
		// 获取当前项目的路径
		String path = System.getProperty("user.dir");
		
		// 文件下载路径配置
		FileSystem fs = FileSystem.get(new URI("hdfs://127.0.0.1:9000"), new Configuration());
		fs.copyToLocalFile(
			false, 
			new Path(downloadPath+filename), 
			new Path(path+"/userFiles/"+rselutFilename), 
			true);
		
		System.out.println(filename +"文件下载成功!");
	}

	public static void deleteFile(String path,String filename) throws Exception {
		FileSystem fs = FileSystem.get(new URI("hdfs://127.0.0.1:9000"), new Configuration());
		// delete 方法的第一个参数表示上传文件的路径,的第二个参数表示是否递归删除,遇到删除文件夹时设为 true
		Boolean flag = fs.delete(new Path(path+filename), true);
		if (flag) {
			System.out.println(filename +"文件删除成功!");
		} else {
			System.out.println(filename +"文件删除失败!");
		}
		
	}
	
}
