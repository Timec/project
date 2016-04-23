package com.core.menu;

public class MenuVO{
	private String access_priv = "";
	private String menu_lvl = "";
	private String menu_nm = "";
	private String control_id = "";
	private String control_kind = "";
	private String menu_ord = "";
	private String sub_ord = "";
	
	private String system = "";
	private String user_id = "";
	private String lang = "";
	
	public MenuVO(){
	}
	
	public MenuVO(String system, String user_id, String lang){
		this.system = system;
		this.user_id = user_id;
		this.setLang(lang);
	}

	public String getAccess_priv() {
		return access_priv;
	}

	public void setAccess_priv(String access_priv) {
		this.access_priv = access_priv;
	}

	public String getMenu_lvl() {
		return menu_lvl;
	}

	public void setMenu_lvl(String menu_lvl) {
		this.menu_lvl = menu_lvl;
	}

	public String getMenu_nm() {
		return menu_nm;
	}

	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}

	public String getControl_id() {
		return control_id;
	}

	public void setControl_id(String control_id) {
		this.control_id = control_id;
	}

	public String getControl_kind() {
		return control_kind;
	}

	public void setControl_kind(String control_kind) {
		this.control_kind = control_kind;
	}

	public String getMenu_ord() {
		return menu_ord;
	}

	public void setMenu_ord(String menu_ord) {
		this.menu_ord = menu_ord;
	}

	public String getSub_ord() {
		return sub_ord;
	}

	public void setSub_ord(String sub_ord) {
		this.sub_ord = sub_ord;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
}
