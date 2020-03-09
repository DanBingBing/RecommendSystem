package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.UserMovieMapper;
import com.movie.pojo.UserMovie;
import com.movie.pojo.UserMovieExample;
import com.movie.service.UserMovieService;

@Service
public class UserMovieServiceImpl implements UserMovieService {
	
	@Autowired
	private UserMovieMapper userMovieMapper;

	/**
	 * 根据电影ID获取电影信息(user_movie)
	 */
	@Override
	public UserMovie getSingle(Integer mId) {
		UserMovie userMovie = userMovieMapper.selectByPrimaryKey(mId);
		return userMovie;
	}
	
	/**
	 * 更新user_movie表中的grade信息(user_movie)
	 */
	@Override
	public void updateGrade(Integer userId,Integer mId,Integer grade) {
		UserMovie userMovie = new UserMovie();
		userMovie.setMovGrade(grade);
		
		UserMovieExample userMovieExample = new UserMovieExample();
		userMovieExample.createCriteria().andUserIdEqualTo(userId);
		userMovieExample.createCriteria().andMovIdEqualTo(mId);
		
		// 根据mov_Id更新mov_grade
		userMovieMapper.updateByExampleSelective(userMovie, userMovieExample);
	}

	/**
	 * 添加用户观看过的电影(user_movie)
	 */
	@Override
	public void addMovieToUser(Integer userId, Integer id) {
		UserMovie userMovie = new UserMovie();
		userMovie.setUserId(userId);
		userMovie.setMovId(id);
		
		userMovieMapper.insertSelective(userMovie);
	}

	/**
	 * 根据用户ID查找用户观看过的所有电影ID(user_movie)
	 */
	@Override
	public List<UserMovie> getHistoryMovies(Integer uId) {
		UserMovieExample userMovieExample = new UserMovieExample();
		userMovieExample.createCriteria().andUserIdEqualTo(uId);
		
		return userMovieMapper.selectByExample(userMovieExample);
	}

}
