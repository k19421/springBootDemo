package com.fcbox.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 使用xml配置的mybatis mapper
 * Created by 000498 on 2016/11/10.
 */
@Mapper
public interface UserXmlMapper {
	String queryEdmUserId(@Param("mobilePhone") String mobilePhone);
}
