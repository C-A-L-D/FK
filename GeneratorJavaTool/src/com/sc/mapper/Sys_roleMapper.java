package com.sc.mapper;

import com.sc.entity.Sys_role;
import com.sc.entity.Sys_roleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sys_roleMapper {
    int countByExample(Sys_roleExample example);

    int deleteByExample(Sys_roleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Sys_role record);

    int insertSelective(Sys_role record);

    List<Sys_role> selectByExample(Sys_roleExample example);

    Sys_role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Sys_role record, @Param("example") Sys_roleExample example);

    int updateByExample(@Param("record") Sys_role record, @Param("example") Sys_roleExample example);

    int updateByPrimaryKeySelective(Sys_role record);

    int updateByPrimaryKey(Sys_role record);
}