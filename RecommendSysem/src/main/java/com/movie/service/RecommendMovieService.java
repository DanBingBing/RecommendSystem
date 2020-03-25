package com.movie.service;

import java.util.List;

import com.movie.pojo.RecommendMovie;

public interface RecommendMovieService {
	
	public void addAllRecommendMovie(RecommendMovie recommendMovie);
	
	public List<RecommendMovie> getAllRecommendListByUserId(Integer uId);
	
	public void deleteAllRecommendMovieByUserId(Integer uId);

}
