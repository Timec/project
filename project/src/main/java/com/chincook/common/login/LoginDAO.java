package com.chincook.common.login;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LoginDAO {
	public List<? extends Role> authList(@Param("user_id") String user_id);
	
	public UserInfo auth(@Param("user_id") String user_id);
	
	public UserInfo userInfo(@Param("user_id") String user_id);
}
