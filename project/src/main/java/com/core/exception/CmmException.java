package com.core.exception;

import com.core.constants.ForwardConstants;

@SuppressWarnings("serial")
public class CmmException extends RuntimeException{
	private String code;
	private String url;
	
	public CmmException(){
		super();
		this.code = "";
		this.url = ForwardConstants.ERROR;
	}
	
	public CmmException(Exception e){
		super(e);
		this.code = "";
		this.url = ForwardConstants.ERROR;
	}
	
	public CmmException(String code){
		super(code);
		this.code = code;
		this.url = ForwardConstants.ERROR;
	}
	
	public CmmException(String code, Exception e){
		super(code, e);
		this.code = code;
		this.url = ForwardConstants.ERROR;
	}
	
	public CmmException(String code, String url){
		super(code);
		this.code = code;
		this.url = url;
	}
	
	public String getCode(){
		if(code == null) code = "";
		return code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	
	public String getForward(){
		if(url == null || url.equals("")) url = ForwardConstants.ERROR;
		return url;
	}
	
	public void setForward(String url){
		this.url = url;
	}
}
