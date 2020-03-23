package com.movie.hadoop;

import java.io.IOException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class StartupRecommend {
	
	@Scheduled(fixedRate=18000000)
	public void run() throws ClassNotFoundException, IOException, InterruptedException {
		MR1.step1();
		System.out.println("启动推荐成功！");
	}

}
