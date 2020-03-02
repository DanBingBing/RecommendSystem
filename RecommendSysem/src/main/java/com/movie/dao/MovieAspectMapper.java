package com.movie.dao;

import com.movie.pojo.MovieAspect;
import com.movie.pojo.MovieAspectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieAspectMapper {
    long countByExample(MovieAspectExample example);

    int deleteByExample(MovieAspectExample example);

    int deleteByPrimaryKey(Integer maId);

    int insert(MovieAspect record);

    int insertSelective(MovieAspect record);

    List<MovieAspect> selectByExample(MovieAspectExample example);

    MovieAspect selectByPrimaryKey(Integer maId);

    int updateByExampleSelective(@Param("record") MovieAspect record, @Param("example") MovieAspectExample example);

    int updateByExample(@Param("record") MovieAspect record, @Param("example") MovieAspectExample example);

    int updateByPrimaryKeySelective(MovieAspect record);

    int updateByPrimaryKey(MovieAspect record);
}