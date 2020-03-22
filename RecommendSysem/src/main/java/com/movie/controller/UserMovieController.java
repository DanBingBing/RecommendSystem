package com.movie.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.utils.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.pojo.Movie;
import com.movie.pojo.UserMovie;
import com.movie.service.MovieService;
import com.movie.service.UserMovieService;

/**
 * 用户对电影的相关操作控制器
 * @author danbingbing
 *
 */
@Controller
@RequestMapping("/userMovie")
public class UserMovieController {
	
	@Autowired
	private UserMovieService userMovieService;
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/addMovieToUser",method=RequestMethod.POST)
	@ResponseBody
	public Message addMovieToUser(@RequestParam("uId")String uId,@RequestParam("mId")String mId) {
		Integer id = Integer.parseInt(mId);
		
		Integer userId = Integer.parseInt(uId);
		
		userMovieService.addMovieToUser(userId,id);
		
		return Message.success().add("msg", "已看完电影，请请为该电影评分，谢谢支持！");
		
	}
	
	@RequestMapping(value="/grade",method=RequestMethod.POST)
	@ResponseBody
	public Message grade(@RequestParam("uId")Integer uId,@RequestParam("mId")Integer mId,@RequestParam("mov_grade")String mov_grade) {
		
		// mov_grade=5要截取出评分5
		String mGrade = mov_grade.substring(mov_grade.length()-1);
		
		Integer grade = Integer.parseInt(mGrade);
		
		// 获取user_movie表中的电影信息
		UserMovie userMovie = userMovieService.getSingle(mId);
		
		// 先判断是否播放了电影(数据中是否为该用户添加了该电影)
		if (userMovie == null) {
			return Message.failed().add("msg", "请先观看电影！");
		} else {

			userMovieService.updateGrade(uId,mId, grade);
			return Message.success().add("msg", "评分成功");
		}
		
	}
	
	@RequestMapping(value="/historyList",method=RequestMethod.POST)
	@ResponseBody
	public Message historyList(@RequestParam(value="pageNumber",defaultValue="1") Integer pageNumber,@RequestParam("uId")Integer uId) {
		// 在查询之前调用，传入页码、以及每页大小
		PageHelper.startPage(pageNumber, 30);
		
		List<UserMovie> list = userMovieService.getHistoryMovies(uId);
		
		List<Movie> historyList = new ArrayList<Movie>();
		
		for(int i=0;i<list.size();i++) {
			Movie movie = movieService.getSingle(list.get(i).getMovId());
			historyList.add(movie);
		}
		
		// 使用pageInfo来封装list集合
		// 因为它里面封装了可在页面使用的数据信息（包括详细的分页信息及查询到的数据）,传入分页导航栏显示的页码数
		PageInfo<Movie> page = new PageInfo<Movie>(historyList,5);
		
		return Message.success().add("historyList", page);
		
	}
	
	/**
	 * 根据mId查询user_movie表中是否存在该电影
	 */
	@RequestMapping(value="/getSingleMovie",method=RequestMethod.POST)
	@ResponseBody
	public Message getSingleMovie(@RequestParam("mId")Integer mId,@RequestParam("uId")Integer uId) {
		List<UserMovie> list = userMovieService.getSingleMovie(mId,uId);
		
		if(list.size()>0) {
			UserMovie movie = list.get(0);
			return Message.success().add("movie", movie);
		}else {
			return Message.failed();
		}
		
	}
	
}
