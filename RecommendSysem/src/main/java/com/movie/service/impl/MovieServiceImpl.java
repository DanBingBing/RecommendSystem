package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MovieMapper;
import com.movie.dao.MovieTagMessageMapper;
import com.movie.pojo.Movie;
import com.movie.pojo.MovieExample;
import com.movie.pojo.MovieTagMessage;
import com.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieTagMessageMapper movieTagMessageMapper;
	
	@Autowired
	private MovieMapper movieMapper;
	
	/**
	 * 三张表的级联查询(movie mov_tag mov_tag_mov)
	 * 		用于初始化电影综合标签信息(mTag)
	 */
	@Override
	public List<MovieTagMessage> getAllMovies() {
		
		List<MovieTagMessage> list = movieTagMessageMapper.selectByExampleWithTag(null);
		
		return list;
	}

	/**
	 * 更新movie表中的mTag信息(movie)
	 */
	@Override
	public void setMtagByMid(int mId, String mTag) {
		Movie movie = new Movie();
		movie.setmTag(mTag);
		MovieExample movieExample = new MovieExample();
		movieExample.createCriteria().andMIdEqualTo(mId);
		
		// 根据mId更新mTag
		movieMapper.updateByExampleSelective(movie, movieExample);
	}

	/**
	 * 获取完整的电影信息列表(movie)
	 */
	@Override
	public List<Movie> getMovieList() {
		List<Movie> list = movieMapper.selectByExample(null);
		return list;
	}

	/**
	 * 根据电影名获取电影信息列表(movie)
	 */
	@Override
	public List<Movie> getSearchList(String mName) {
		MovieExample movieExample = new MovieExample();
		
		// 模糊查询（需要拼接%符号，这样就可以不用修改mapper.xml中的内容）
		movieExample.createCriteria().andMNameLike("%"+mName+"%");
		
		List<Movie> list = movieMapper.selectByExample(movieExample);
		
		return list;
	}

	/**
	 * 根据电影ID获取电影信息(movie)
	 */
	@Override
	public Movie getSingle(Integer mId) {
		Movie movie = movieMapper.selectByPrimaryKey(mId);
		return movie;
	}

}
