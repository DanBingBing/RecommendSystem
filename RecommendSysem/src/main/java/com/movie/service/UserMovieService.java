package com.movie.service;

import java.util.List;

import com.movie.pojo.UserMovie;;

public interface UserMovieService {

	public UserMovie getSingle(Integer mId);
	
	public void updateGrade(Integer userMId, Integer id, Integer grade);

	public void addMovieToUser(Integer userId, Integer id);

	public List<UserMovie> getHistoryMovies(Integer uId);

	public List<UserMovie> getSingleMovie(Integer mId,Integer uId);
}
