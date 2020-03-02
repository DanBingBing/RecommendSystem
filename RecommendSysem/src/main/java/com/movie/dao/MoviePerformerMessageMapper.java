package com.movie.dao;

import com.movie.pojo.MoviePerformerMessage;
import com.movie.pojo.MoviePerformerMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoviePerformerMessageMapper {
    long countByExample(MoviePerformerMessageExample example);

    int deleteByExample(MoviePerformerMessageExample example);

    int deleteByPrimaryKey(Integer mpmId);

    int insert(MoviePerformerMessage record);

    int insertSelective(MoviePerformerMessage record);

    List<MoviePerformerMessage> selectByExample(MoviePerformerMessageExample example);

    MoviePerformerMessage selectByPrimaryKey(Integer mpmId);

    int updateByExampleSelective(@Param("record") MoviePerformerMessage record, @Param("example") MoviePerformerMessageExample example);

    int updateByExample(@Param("record") MoviePerformerMessage record, @Param("example") MoviePerformerMessageExample example);

    int updateByPrimaryKeySelective(MoviePerformerMessage record);

    int updateByPrimaryKey(MoviePerformerMessage record);
}