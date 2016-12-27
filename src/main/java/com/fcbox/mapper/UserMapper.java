package com.fcbox.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * userMapper
 * Created by 000498 on 2016/11/2.
 */
@Mapper
public interface UserMapper {
	@Select("select edm_user_id from edm_user where user_mobilephone=#{mobilePhone}")
	String queryEdmUserId(@Param("mobilePhone") String mobilePhone);
}
