package com.movie.dao;

import com.movie.pojo.UserTag;
import com.movie.pojo.UserTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTagMapper {
    long countByExample(UserTagExample example);

    int deleteByExample(UserTagExample example);

    int deleteByPrimaryKey(Integer utId);

    int insert(UserTag record);

    int insertSelective(UserTag record);

    List<UserTag> selectByExample(UserTagExample example);

    UserTag selectByPrimaryKey(Integer utId);

    int updateByExampleSelective(@Param("record") UserTag record, @Param("example") UserTagExample example);

    int updateByExample(@Param("record") UserTag record, @Param("example") UserTagExample example);

    int updateByPrimaryKeySelective(UserTag record);

    int updateByPrimaryKey(UserTag record);
}