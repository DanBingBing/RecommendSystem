package com.movie.hadoop;

import com.movie.fileOperation.HDFSFileOperation;

public class StartupRecommend {
	
	public static void startupRecommend(Integer uId, String hadoopUrl,String step1InputPath,String step2InputPath,String step1OutputPath,String step2OutputPath,String step3OutputPath) throws Exception {
		// "ItemProfile_"+uId+".txt", "ItemUser_"+uId+".txt", "RecommendResult_"+uId
		
		// 上传电影特征文件(上传到HDFS的路径，上传的文件)
		// "hdfs://127.0.0.1:9000/context/step1_input/"
		HDFSFileOperation.uploadFile(hadoopUrl+step1InputPath+"_"+uId+"/", "ItemProfile_"+uId+".txt");
		
		// 上传用户评分文件
		// "hdfs://127.0.0.1:9000/context/step2_input/"
		HDFSFileOperation.uploadFile(hadoopUrl+step2InputPath+"_"+uId+"/", "ItemUser_"+uId+".txt");
		
		// 启动推荐算法
		MR1.step1(uId,hadoopUrl,step1InputPath+"_"+uId+"/",step1OutputPath+"_"+uId,"RecommendResult_"+uId+"_temp1");
		
		MR2.step2(uId,hadoopUrl,step2InputPath+"_"+uId+"/",step2OutputPath+"_"+uId,"RecommendResult_"+uId+"_temp2",step1OutputPath+"_"+uId+"/RecommendResult_"+uId+"_temp1-r-00000");
		
		MR3.step3(uId,hadoopUrl,step1InputPath+"_"+uId+"/",step3OutputPath+"_"+uId,"RecommendResult_"+uId,step2OutputPath+"_"+uId+"/RecommendResult_"+uId+"_temp2-r-00000");
		
		// 从HDFS中下载推荐结果并保存到downloadFilename,HDFS生成的后缀为 -r-00000
		// "hdfs://127.0.0.1:9000/context/step3_output/"
		HDFSFileOperation.downloadFile(hadoopUrl+step3OutputPath+"_"+uId+"/","RecommendResult_"+uId+"-r-00000","RecommendResult_"+uId+".txt");
		System.out.println("启动推荐成功！");
	}

}
