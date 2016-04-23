package com.chincook.notice;

import com.core.common.vo.GenericVO;

@SuppressWarnings("serial")
public class NoticeVO extends GenericVO{
	private String title = "";
	private String content = "";
	private String bbs_id = "";
	private String cn_id = "";
	
	public String getBbs_id() {
		return bbs_id;
	}
	public void setBbs_id(String bbs_id) {
		this.bbs_id = bbs_id;
	}
	public String getCn_id() {
		return cn_id;
	}
	public void setCn_id(String cn_id) {
		this.cn_id = cn_id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
