package com.movie.dao;

import com.movie.pojo.MoviePerformer;
import com.movie.pojo.MoviePerformerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoviePerformerMapper {
    long countByExample(MoviePerformerExample example);

    int deleteByExample(MoviePerformerExample example);

    int deleteByPrimaryKey(Integer mpId);

    int insert(MoviePerformer record);

    int insertSelective(MoviePerformer record);

    List<MoviePerformer> selectByExample(MoviePerformerExample example);

    MoviePerformer selectByPrimaryKey(Integer mpId);

    int updateByExampleSelective(@Param("record") MoviePerformer record, @Param("example") MoviePerformerExample example);

    int updateByExample(@Param("record") MoviePerformer record, @Param("example") MoviePerformerExample example);

    int updateByPrimaryKeySelective(MoviePerformer record);

    int updateByPrimaryKey(MoviePerformer record);
}