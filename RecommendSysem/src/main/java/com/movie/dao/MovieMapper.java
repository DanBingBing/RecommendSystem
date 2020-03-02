package com.movie.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.movie.pojo.Movie;
import com.movie.pojo.MovieExample;

public interface MovieMapper {
    long countByExample(MovieExample example);

    int deleteByExample(MovieExample example);

    int deleteByPrimaryKey(Integer mId);

    int insert(Movie record);

    int insertSelective(Movie record);

    List<Movie> selectByExample(MovieExample example);

    Movie selectByPrimaryKey(Integer mId);

    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}