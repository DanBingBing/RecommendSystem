package com.movie.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.pojo.MovieTag;
import com.movie.service.TagService;
import com.movie.utils.Message;

@Controller
@RequestMapping("/movieTag")
public class MovieTagController {
	
	private TagService tagService;
	
	/**
	 * 获取所有标签信息
	 * @return Message
	 */
	@RequestMapping(value="/getAllTag",method=RequestMethod.POST)
	@ResponseBody
	public Message getAllTag() {
		List<MovieTag> tagList = tagService.getTags();
		
		return Message.success().add("tagList", tagList);
	}

}
