package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MovieTagMapper;
import com.movie.pojo.MovieTag;
import com.movie.service.TagService;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private MovieTagMapper movieTagMapper;

	/**
	 * 查询mov_tag表中的所有信息
	 */
	@Override
	public List<MovieTag> getTags() {
		
		List<MovieTag> tags = movieTagMapper.selectByExample(null);
		return tags;
	}

}
