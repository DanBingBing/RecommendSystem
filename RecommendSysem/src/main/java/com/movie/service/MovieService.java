package com.movie.service;

import java.util.List;

import com.movie.pojo.Movie;
import com.movie.pojo.MovieTagMessage;

public interface MovieService {

	public List<MovieTagMessage> getAllMovies();

	public void setMtagByMid(int mId, String mTag);

	public List<Movie> getMovieList();

	public List<Movie> getSearchList(String mName);	

}
