package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.movie.pojo.RecommendMovie;
import com.movie.service.RecommendMovieService;
import com.movie.utils.FileSaveToListUtil;
import com.movie.utils.Message;

@Controller
public class RecommendMovieController {
	
	@Autowired
	private RecommendMovieService recommendMovieService;
	
	@Scheduled(fixedRate=18000000) 
	public Message getRecommendMovies() throws Exception {
		
		List<RecommendMovie> list = FileSaveToListUtil.getRecommendList();
		  
		for(int i=0;i<list.size();i++) {
			recommendMovieService.addAllRecommendMovie(list.get(i)); 
		}
		 
		System.out.println("保存成功！");
		
		return null;
	}
	
}
