package com.core.common.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public abstract class GenericVO implements BaseVO{
	/*
     * Element
     */
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	
	private String msg = "";
	private boolean success = true;
	
	private String username = "";
	private String user_ip = "";
	
	private String cmd = "";
	private String lang = "";
    
    private String result = "";
    
    private String total_cnt = "";
    private String page_st = "";
    private String page_ed = "";
    
    private String current_page = "";
    private String current_page_depth = "";
    
    private String url = "";
    private String error_url = "";
    
    public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}


	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTotal_cnt() {
		return total_cnt;
	}

	public void setTotal_cnt(String total_cnt) {
		this.total_cnt = total_cnt;
	}

	public String getPage_st() {
		return page_st;
	}

	public void setPage_st(String page_st) {
		this.page_st = page_st;
	}

	public String getPage_ed() {
		return page_ed;
	}

	public void setPage_ed(String page_ed) {
		this.page_ed = page_ed;
	}

	public String getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(String current_page) {
		this.current_page = current_page;
	}

	public String getCurrent_page_depth() {
		return current_page_depth;
	}

	public void setCurrent_page_depth(String current_page_depth) {
		this.current_page_depth = current_page_depth;
	}

	public String getError_url() {
		return error_url;
	}

	public void setError_url(String error_url) {
		this.error_url = error_url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setForwardUrl(String url){
		this.url = url;
		this.error_url = url;
	}
	
	public void setForwardUrl(String url, String error_url){
		this.url = url;
		this.error_url = error_url;
	}
	
	public void setForwardUrl(String url, String error_url, boolean redirect){
		this.url = "redirect:/"+url;
		this.error_url = "redirect/:"+error_url;
	}
	public void setForwardUrl(String url, boolean redirect){
		this.url = "redirect:/"+url;
		this.error_url = "redirect:/"+url;
	}
	
	public String getUrl(){
		return this.url;			
	}
	
	public String getErrorUrl(){
		return this.error_url;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
