package com.core.common.vo;

import java.sql.Date;

public class ExcelFileVO extends GenericVO{

	private int seq = 0;
    private String group_nm = "";
    private String file_nm = "";
    private String save_file_nm = "";
    private int file_size = 0;
    private String file_content_type = "";
    private int download_cnt = 0;
    private String error_msg = "";
    private String error_log = "";
    private String crt_id = "";
    private String crt_ip = "";
    private Date crt_dt = null;
    private String udt_id = "";
    private String udt_ip = "";
    private Date udt_dt = null;
    
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getGroup_nm() {
		return group_nm;
	}
	public void setGroup_nm(String group_nm) {
		this.group_nm = group_nm;
	}
	public String getFile_nm() {
		return file_nm;
	}
	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}
	public String getSave_file_nm() {
		return save_file_nm;
	}
	public void setSave_file_nm(String save_file_nm) {
		this.save_file_nm = save_file_nm;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public String getFile_content_type() {
		return file_content_type;
	}
	public void setFile_content_type(String file_content_type) {
		this.file_content_type = file_content_type;
	}
	public int getDownload_cnt() {
		return download_cnt;
	}
	public void setDownload_cnt(int download_cnt) {
		this.download_cnt = download_cnt;
	}
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
	public String getError_log() {
		return error_log;
	}
	public void setError_log(String error_log) {
		this.error_log = error_log;
	}
	public String getCrt_id() {
		return crt_id;
	}
	public void setCrt_id(String crt_id) {
		this.crt_id = crt_id;
	}
	public String getCrt_ip() {
		return crt_ip;
	}
	public void setCrt_ip(String crt_ip) {
		this.crt_ip = crt_ip;
	}
	public Date getCrt_dt() {
		return crt_dt;
	}
	public void setCrt_dt(Date crt_dt) {
		this.crt_dt = crt_dt;
	}
	public String getUdt_id() {
		return udt_id;
	}
	public void setUdt_id(String udt_id) {
		this.udt_id = udt_id;
	}
	public String getUdt_ip() {
		return udt_ip;
	}
	public void setUdt_ip(String udt_ip) {
		this.udt_ip = udt_ip;
	}
	public Date getUdt_dt() {
		return udt_dt;
	}
	public void setUdt_dt(Date udt_dt) {
		this.udt_dt = udt_dt;
	}
    
}
