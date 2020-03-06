package com.movie.service;

import com.movie.pojo.UserMovie;;

public interface UserMovieService {

	public UserMovie getSingle(Integer mId);
	
	public void updateGrade(Integer userMId, Integer id, Integer grade);

	public void addMovieToUser(Integer userId, Integer id);
}
