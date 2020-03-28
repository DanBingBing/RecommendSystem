package com.movie.hadoop;

import com.movie.fileOperation.HDFSFileOperation;

public class StartupRecommend {
	
	public static void startupRecommend(String ItemProfileFilename,String ItemUserFilename,String rselutFilename) throws Exception {
		// 上传电影特征文件(上传到HDFS的路径，上传的文件)
		HDFSFileOperation.uploadFile("hdfs://127.0.0.1:9000/context/step1_input/", ItemProfileFilename);
		// 上传用户评分文件
		HDFSFileOperation.uploadFile("hdfs://127.0.0.1:9000/context/step2_input/", ItemUserFilename);
		
		// 启动推荐算法
		MR1.step1(rselutFilename+"_temp1");
		
		MR2.step2(rselutFilename+"_temp2",rselutFilename+"_temp1-r-00000");
		
		MR3.step3(rselutFilename,rselutFilename+"_temp2-r-00000");
		
		// 从HDFS中下载推荐结果并保存到downloadFilename,HDFS生成的后缀为 -r-00000
		HDFSFileOperation.downloadFile("hdfs://127.0.0.1:9000/context/step3_output/",rselutFilename+"-r-00000",rselutFilename+".txt");
		System.out.println("启动推荐成功！");
	}

}
