package com.movie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.utils.Message;
import com.movie.pojo.UserMovie;
import com.movie.service.UserMovieService;

@Controller
@RequestMapping("/userMovie")
public class UserMovieController {
	
	@Autowired
	private UserMovieService userMovieService;
	
	@RequestMapping("/addMovieToUser")
	@ResponseBody
	public Message addMovieToUser(@RequestParam("uId")String uId,@RequestParam("mId")String mId) {
		Integer id = Integer.parseInt(mId);
		
		Integer userId = Integer.parseInt(uId);
		
		userMovieService.addMovieToUser(userId,id);
		
		return Message.success().add("msg", "已看完电影，请请为该电影评分，谢谢支持！");
		
	}
	
	@RequestMapping("/grade")
	@ResponseBody
	public Message grade(@RequestParam("uId")String uId,@RequestParam("mId")String mId,@RequestParam("mov_grade")String mov_grade) {
		Integer id = Integer.parseInt(mId);
		
		// mov_grade=5要截取出评分5
		String mGrade = mov_grade.substring(mov_grade.length()-1);
		
		Integer grade = Integer.parseInt(mGrade);
		
		// 获取user_movie表中的电影信息
		UserMovie userMovie = userMovieService.getSingle(id);
		
		// 先判断是否播放了电影(数据中是否为该用户添加了该电影)
		if (userMovie == null) {
			return Message.failed().add("msg", "请先观看电影！");
		} else {
			Integer userId = Integer.parseInt(uId);
			userMovieService.updateGrade(userId,id, grade);
			return Message.success().add("msg", "评分成功");
		}
		
	}
	
}
