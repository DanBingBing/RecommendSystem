package com.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.UserTagMapper;
import com.movie.pojo.UserTag;
import com.movie.service.UserTagService;

@Service
public class UserTagServiceImpl implements UserTagService {
	
	@Autowired
	private UserTagMapper userTagMapper;

	/**
	 * 为新用户添加兴趣标签
	 */
	@Override
	public void addUserTag(Integer userId,String tagName) {
		UserTag userTag = new UserTag();
		userTag.setUserId(userId);
		userTag.setUtName(tagName);
		
		userTagMapper.insertSelective(userTag);
	}

}
