package com.chincook.common.login;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public class UserInfo implements UserDetails{
	private static final long serialVersionUID = -1594569634702498108L;

	private String current_system_cd = "";
	
	private String user_id;
	private String password;
	
	//-------
    private String user_nm = "";
    
    private String userGroupId = "";         

    private String userDeptCd = "";   
    
    private String userVenueCd = "";
    
	private String user_ip = "";
    
    private String userIdx1 = "";

    private String userIdx2 = "";

    private String userIdx3 = "";

    private String userIdx4 = "";

    private String userIdx5 = "";
	
	//-------
	
	private List<? extends Role> auth;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	
	private String salt = "";
	
	@Override
	public Collection<? extends Role> getAuthorities() {
		// TODO Auto-generated method stub
		return this.auth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user_id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setUsername(String username) {
		this.user_id = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuth(List<? extends Role> auth) {
		this.auth = auth;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserDeptCd() {
		return userDeptCd;
	}

	public void setUserDeptCd(String userDeptCd) {
		this.userDeptCd = userDeptCd;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public String getUserIdx1() {
		return userIdx1;
	}

	public void setUserIdx1(String userIdx1) {
		this.userIdx1 = userIdx1;
	}

	public String getUserIdx2() {
		return userIdx2;
	}

	public void setUserIdx2(String userIdx2) {
		this.userIdx2 = userIdx2;
	}

	public String getUserIdx3() {
		return userIdx3;
	}

	public void setUserIdx3(String userIdx3) {
		this.userIdx3 = userIdx3;
	}

	public String getUserIdx4() {
		return userIdx4;
	}

	public void setUserIdx4(String userIdx4) {
		this.userIdx4 = userIdx4;
	}

	public String getUserIdx5() {
		return userIdx5;
	}

	public void setUserIdx5(String userIdx5) {
		this.userIdx5 = userIdx5;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

    public String getUserVenueCd() {
		return userVenueCd;
	}

	public void setUserVenueCd(String userVenueCd) {
		this.userVenueCd = userVenueCd;
	}

	public String getCurrent_system_cd() {
		return current_system_cd;
	}

	public void setCurrent_system_cd(String current_system_cd) {
		this.current_system_cd = current_system_cd;
	}
}
