package com.chincook.common.login;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority{
	private static final long serialVersionUID = -8333002979968100368L;

	private String name;
	private String permission;
	private String accesspriv;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getAccesspriv() {
		return accesspriv;
	}

	public void setAccesspriv(String accesspriv) {
		this.accesspriv = accesspriv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
}
