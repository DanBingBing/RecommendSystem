package com.movie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.pojo.Movie;
import com.movie.pojo.RecommendMovie;
import com.movie.service.MovieService;
import com.movie.service.RecommendMovieService;
import com.movie.utils.FileSaveToListUtil;
import com.movie.utils.JsonUtil;
import com.movie.utils.ListPagerUtil;
import com.movie.utils.Message;
import com.movie.utils.SortListUtil;

@Controller
@RequestMapping("/recommend")
public class RecommendMovieController {
	
	@Autowired
	private RecommendMovieService recommendMovieService;
	
	@Autowired
	private MovieService movieService;
	
	//@Scheduled(fixedRate=18000000) 
	public Message getRecommendMovies() throws Exception {
		
		List<RecommendMovie> list = FileSaveToListUtil.getRecommendList();
		  
		for(int i=0;i<list.size();i++) {
			recommendMovieService.addAllRecommendMovie(list.get(i)); 
		}
		 
		System.out.println("保存成功！");
		
		return null;
	}
	
	/**
	 * 获取推荐电影信息列表
	 * @return
	 */
	@RequestMapping(value="/recommendList",method=RequestMethod.POST)
	@ResponseBody
	public Message movieList(@RequestParam(value="pageNumber",defaultValue="1") Integer pageNumber,@RequestParam("uId")Integer uId) {
		// 查询用户所有的推荐电影
		List<RecommendMovie> list = recommendMovieService.getAllRecommendListByUserId(uId);

		// 调用对象集合排序工具类对集合中的 recGrade 进行降序排列
		SortListUtil.sort(list, "recGrade", SortListUtil.DESC);
		
		// 该list封装了所有的电影信息
		List<Movie> movieList = new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			movieList.add(movieService.getSingle(list.get(i).getMovId()));
		}
		
		// 调用自定义的集合分页工具，传入参数要分页的集合、页码、以及每页大小
		// （伪分页，表示依然要从数据库查询所有的数据保存到集合中，对集合进行分页，主要用于信息量不大的数据）
		ListPagerUtil<Movie> page = new ListPagerUtil<Movie>(movieList,pageNumber,30);
				
		System.out.println(JsonUtil.objectToJson(page));
		return Message.success().add("movieList", page);
	
	}
	
}
