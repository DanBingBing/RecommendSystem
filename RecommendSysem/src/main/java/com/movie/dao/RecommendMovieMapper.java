package com.movie.dao;

import com.movie.pojo.RecommendMovie;
import com.movie.pojo.RecommendMovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendMovieMapper {
    long countByExample(RecommendMovieExample example);

    int deleteByExample(RecommendMovieExample example);

    int deleteByPrimaryKey(Integer recId);

    int insert(RecommendMovie record);

    int insertSelective(RecommendMovie record);

    List<RecommendMovie> selectByExample(RecommendMovieExample example);

    RecommendMovie selectByPrimaryKey(Integer recId);

    int updateByExampleSelective(@Param("record") RecommendMovie record, @Param("example") RecommendMovieExample example);

    int updateByExample(@Param("record") RecommendMovie record, @Param("example") RecommendMovieExample example);

    int updateByPrimaryKeySelective(RecommendMovie record);

    int updateByPrimaryKey(RecommendMovie record);
}