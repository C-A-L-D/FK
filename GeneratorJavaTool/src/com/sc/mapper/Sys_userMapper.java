package com.sc.mapper;

import com.sc.entity.Sys_user;
import com.sc.entity.Sys_userExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sys_userMapper {
    int countByExample(Sys_userExample example);

    int deleteByExample(Sys_userExample example);

    int deleteByPrimaryKey(String id);

    int insert(Sys_user record);

    int insertSelective(Sys_user record);

    List<Sys_user> selectByExample(Sys_userExample example);

    Sys_user selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Sys_user record, @Param("example") Sys_userExample example);

    int updateByExample(@Param("record") Sys_user record, @Param("example") Sys_userExample example);

    int updateByPrimaryKeySelective(Sys_user record);

    int updateByPrimaryKey(Sys_user record);
}