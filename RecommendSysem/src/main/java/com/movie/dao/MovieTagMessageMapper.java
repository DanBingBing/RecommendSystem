package com.movie.dao;

import com.movie.pojo.MovieExample;
import com.movie.pojo.MovieTagMessage;
import com.movie.pojo.MovieTagMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieTagMessageMapper {
    long countByExample(MovieTagMessageExample example);

    int deleteByExample(MovieTagMessageExample example);

    int deleteByPrimaryKey(Integer mtmId);

    int insert(MovieTagMessage record);

    int insertSelective(MovieTagMessage record);

    List<MovieTagMessage> selectByExample(MovieTagMessageExample example);
    
    //自定义级联查询
    List<MovieTagMessage> selectByExampleWithTag(MovieExample example);

    MovieTagMessage selectByPrimaryKey(Integer mtmId);

    int updateByExampleSelective(@Param("record") MovieTagMessage record, @Param("example") MovieTagMessageExample example);

    int updateByExample(@Param("record") MovieTagMessage record, @Param("example") MovieTagMessageExample example);

    int updateByPrimaryKeySelective(MovieTagMessage record);

    int updateByPrimaryKey(MovieTagMessage record);
}