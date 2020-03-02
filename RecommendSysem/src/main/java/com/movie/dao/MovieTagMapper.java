package com.movie.dao;

import com.movie.pojo.MovieTag;
import com.movie.pojo.MovieTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieTagMapper {
    long countByExample(MovieTagExample example);

    int deleteByExample(MovieTagExample example);

    int deleteByPrimaryKey(Integer mtId);

    int insert(MovieTag record);

    int insertSelective(MovieTag record);

    List<MovieTag> selectByExample(MovieTagExample example);

    MovieTag selectByPrimaryKey(Integer mtId);

    int updateByExampleSelective(@Param("record") MovieTag record, @Param("example") MovieTagExample example);

    int updateByExample(@Param("record") MovieTag record, @Param("example") MovieTagExample example);

    int updateByPrimaryKeySelective(MovieTag record);

    int updateByPrimaryKey(MovieTag record);
}