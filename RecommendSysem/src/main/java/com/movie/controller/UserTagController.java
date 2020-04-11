package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.service.UserTagService;
import com.movie.utils.Message;

@Controller
@RequestMapping("/userTag")
public class UserTagController {
	
	@Autowired
	private UserTagService userTagService;
	
	/**
	 * 为新用户添加兴趣标签
	 * @param uId
	 * @param userTag
	 * @return Message
	 */
	@RequestMapping(value="/addUserTag",method=RequestMethod.POST)
	@ResponseBody
	public Message addUserTag(@RequestParam("uId")Integer uId,@RequestParam("userTag")String userTag) {
		
		userTagService.addUserTag(uId, userTag);
		
		return Message.success().add("msg", "为新用户添加兴趣标签成功！");
		
	}
	
}
