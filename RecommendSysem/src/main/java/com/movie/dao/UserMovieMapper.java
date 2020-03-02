package com.movie.dao;

import com.movie.pojo.UserMovie;
import com.movie.pojo.UserMovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMovieMapper {
    long countByExample(UserMovieExample example);

    int deleteByExample(UserMovieExample example);

    int deleteByPrimaryKey(Integer umId);

    int insert(UserMovie record);

    int insertSelective(UserMovie record);

    List<UserMovie> selectByExample(UserMovieExample example);

    UserMovie selectByPrimaryKey(Integer umId);

    int updateByExampleSelective(@Param("record") UserMovie record, @Param("example") UserMovieExample example);

    int updateByExample(@Param("record") UserMovie record, @Param("example") UserMovieExample example);

    int updateByPrimaryKeySelective(UserMovie record);

    int updateByPrimaryKey(UserMovie record);
}