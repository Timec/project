package com.core.common;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.core.constants.MessageConstants;

public abstract class CmmController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("cmmMessages")
	private CmmMessages cmmMessages;
	
	public String getMessage(String code, Locale locale){
		cmmMessages.setCode(code);
//		cmmMessages.setLocale(locale);
		
		return cmmMessages.getMessage();
	}
	
	public String getMessage(String code, Locale locale, Object ... params){
		cmmMessages.setCode(code);
//		cmmMessages.setLocale(locale);
		
		return cmmMessages.getMessage(params);
	}
	
	public String getMessage(Locale locale){
		cmmMessages.setCode(MessageConstants.defaultErrorCode);
//		cmmMessages.setLocale(locale);
		
		return cmmMessages.getMessage();
	}
}
