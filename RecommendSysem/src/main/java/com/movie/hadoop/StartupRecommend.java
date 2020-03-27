package com.movie.hadoop;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.movie.utils.HDFSFileOperationUtil;

@Controller
public class StartupRecommend {
	
	//@Scheduled(fixedRate=18000000)
	public void startupRecommend() throws Exception {
		// 上传电影特征文件(上传到HDFS的路径，上传的文件)
		HDFSFileOperationUtil.uploadFile("hdfs://127.0.0.1:9000/context/step1_input/", "ItemProfile.txt");
		// 上传用户评分文件
		HDFSFileOperationUtil.uploadFile("hdfs://127.0.0.1:9000/context/step2_input/", "ItemUser.txt");
		// 启动推荐算法
		MR1.step1();
		// 从HDFS中下载推荐结果
		HDFSFileOperationUtil.downloadFile("hdfs://127.0.0.1:9000/context/step3_output/","part-r-00000");
		System.out.println("启动推荐成功！");
	}

}
