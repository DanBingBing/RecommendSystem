package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MovieTagMessageMapper;
import com.movie.dao.UserTagMapper;
import com.movie.pojo.MovieTagMessage;
import com.movie.pojo.MovieTagMessageExample;
import com.movie.pojo.UserTag;
import com.movie.pojo.UserTagExample;
import com.movie.service.UserTagService;

@Service
public class UserTagServiceImpl implements UserTagService {
	
	@Autowired
	private UserTagMapper userTagMapper;
	
	@Autowired
	private MovieTagMessageMapper movieTagMessageMapper;

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
	
	/**
	 * 根据用户id获取用户兴趣标签
	 */
	@Override
	public List<UserTag> getUserTag(Integer userId) {
		UserTagExample userTagExample = new UserTagExample();
		userTagExample.createCriteria().andUserIdEqualTo(userId);
		
		return userTagMapper.selectByExample(userTagExample);
	}
	
	/**
	 * 根据标签id获取用户兴趣标签相关电影列表
	 */
	@Override
	public List<MovieTagMessage> getMovieTagMessage(Integer tagId) {
		MovieTagMessageExample mtmExample = new MovieTagMessageExample();
		mtmExample.createCriteria().andTagIdEqualTo(tagId);
		
		return movieTagMessageMapper.selectByExample(mtmExample);
	}

}
