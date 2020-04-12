package com.movie.service;

import java.util.List;

import com.movie.pojo.MovieTagMessage;
import com.movie.pojo.UserTag;

public interface UserTagService {
	
	public void addUserTag(Integer userId, String tagName);
	
	public List<UserTag> getUserTag(Integer userId);

	public List<MovieTagMessage> getMovieTagMessage(Integer tagId);
}
