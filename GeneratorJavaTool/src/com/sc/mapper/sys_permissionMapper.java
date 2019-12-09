package com.sc.mapper;

import com.sc.entity.sys_permission;
import com.sc.entity.sys_permissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface sys_permissionMapper {
    int countByExample(sys_permissionExample example);

    int deleteByExample(sys_permissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(sys_permission record);

    int insertSelective(sys_permission record);

    List<sys_permission> selectByExample(sys_permissionExample example);

    sys_permission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") sys_permission record, @Param("example") sys_permissionExample example);

    int updateByExample(@Param("record") sys_permission record, @Param("example") sys_permissionExample example);

    int updateByPrimaryKeySelective(sys_permission record);

    int updateByPrimaryKey(sys_permission record);
}