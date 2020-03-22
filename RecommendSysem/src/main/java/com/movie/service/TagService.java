package com.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.pojo.MovieTag;

public interface TagService {
	
	public List<MovieTag> getTags();
}
