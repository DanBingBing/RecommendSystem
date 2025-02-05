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
import com.movie.pojo.User;
import com.movie.pojo.UserMovie;
import com.movie.pojo.UserTag;
import com.movie.service.MovieService;
import com.movie.service.UserMovieService;
import com.movie.service.UserService;
import com.movie.service.UserTagService;

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
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserTagService userTagService;
	
	/**
	 * 根据用户ID和电影ID为用户添加观影记录
	 * @param uId
	 * @param mId
	 * @return
	 */
	@RequestMapping(value="/addMovieToUser",method=RequestMethod.POST)
	@ResponseBody
	public Message addMovieToUser(@RequestParam("uId")String uId,@RequestParam("mId")String mId) {
		Integer id = Integer.parseInt(mId);
		
		Integer userId = Integer.parseInt(uId);
		
		// 获取user_movie表中的电影信息
		List<UserMovie> list = userMovieService.getSingleMovie(id,userId);
				
		// 先判断是否播放了电影(数据中是否为该用户添加了该电影)
		if (list.size()>0) {
			return Message.success().add("msg", "谢谢再次观看本电影！");
		}else {
			userMovieService.addMovieToUser(userId,id);
			return Message.success().add("msg", "已看完电影，请为该电影评分，谢谢支持！");
		}
		
	}
	
	/**
	 * 根据用户ID和电影ID为用户观看的电影评分
	 * @param uId
	 * @param mId
	 * @param mov_grade
	 * @return
	 */
	@RequestMapping(value="/grade",method=RequestMethod.POST)
	@ResponseBody
	public Message grade(@RequestParam("uId")Integer uId,@RequestParam("mId")Integer mId,@RequestParam("mov_grade")String mov_grade) {
		
		// mov_grade=5要截取出评分5
		String mGrade = mov_grade.substring(mov_grade.length()-1);
		
		Integer grade = Integer.parseInt(mGrade);
		
		// 获取user_movie表中的电影信息
		List<UserMovie> list = userMovieService.getSingleMovie(mId,uId);
		
		// 先判断是否播放了电影(数据中是否为该用户添加了该电影)
		if (list.size()>0) {
			userMovieService.updateGrade(uId,mId, grade);
			return Message.success().add("msg", "评分成功");
		} else {
			return Message.failed().add("msg", "请先观看电影！");
		}
		
	}
	
	/**
	 * 根据用户Id查询用户的历史观影记录
	 * @param pageNumber
	 * @param uId
	 * @return
	 */
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
	 * 根据电影ID查询user_movie表中是否存在该电影
	 * @param mId
	 * @param uId
	 * @return
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
	
	/**
	 * 根据用户名判断用户是否为新用户
	 * @param username
	 * @return Message
	 */
	@RequestMapping(value="/newUserCheck",method=RequestMethod.POST)
	@ResponseBody
	public Message newUserCheck(@RequestParam("username")String username) {
		
		// 根据用户名获取用户信息
		List<User> user = userService.findUsername(username);
		
		//根据用户id获取user_movie表中的用户观影历史信息
		List<UserMovie> list = userMovieService.getHistoryMovies(user.get(0).getId());
		
		List<UserTag> utList = userTagService.getUserTag(user.get(0).getId());
				
		// 判断该用户是否为新用户或没有观影记录的用户
		if (list.size()>0) {
			return Message.success().add("msg", "欢迎！");
		}else if(utList.size()>0){
			return Message.failed().add("flag", true);
		}else {
			return Message.failed().add("flag", false);
		}
		
	}
	
}
