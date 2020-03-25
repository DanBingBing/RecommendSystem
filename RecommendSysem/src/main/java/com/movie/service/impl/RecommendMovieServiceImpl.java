package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.RecommendMovieMapper;
import com.movie.pojo.RecommendMovie;
import com.movie.pojo.RecommendMovieExample;
import com.movie.service.RecommendMovieService;

@Service
public class RecommendMovieServiceImpl implements RecommendMovieService {

	@Autowired
	private RecommendMovieMapper recommendMovieMapper;
	
	/**
	 * 添加所有用户的电影推荐信息
	 */
	@Override
	public void addAllRecommendMovie(RecommendMovie recommendMovie) {

		recommendMovieMapper.insertSelective(recommendMovie);
	}

	/**
	 * 根据用户ID获取用户的推荐电影信息
	 */
	@Override
	public List<RecommendMovie> getAllRecommendListByUserId(Integer uId) {
		RecommendMovieExample example = new RecommendMovieExample();
		example.createCriteria().andUserIdEqualTo(uId);
		
		List<RecommendMovie> list = recommendMovieMapper.selectByExample(example);
		return list;
	}
	
	/**
	 * 根据用户ID删除用户的推荐电影信息
	 */
	@Override
	public void deleteAllRecommendMovieByUserId(Integer uId) {
		
		RecommendMovieExample example = new RecommendMovieExample();
		example.createCriteria().andUserIdEqualTo(uId);
		
		recommendMovieMapper.deleteByExample(example);
	}

}
