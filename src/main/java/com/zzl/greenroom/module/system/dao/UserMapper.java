package com.zzl.greenroom.module.system.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.greenroom.module.code.User;
@Mapper
public interface UserMapper extends BaseMapper<User> {
	
}
