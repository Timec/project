package com.core.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.ui.Model;

import com.core.common.CmmMessageUtil;
import com.core.common.vo.BaseVO;
import com.core.exception.CmmException;

public class CmmBeanUtils extends BeanUtils{
	/**
	  Map Data Binding
	  [data -> target]
	 * @param target
	 * @param data
	 * @throws SiccException
	 */
	public static void populate(Object target, Map<String, ? extends Object> data) throws CmmException {
		for (Entry<String, ? extends Object> ele : data.entrySet()) {
			try {
				BeanUtils.setProperty(target, ele.getKey().toLowerCase(), ele.getValue());
			} catch (IllegalAccessException e) {
				throw CmmMessageUtil.getError(e);
			} catch (InvocationTargetException e) {
				throw CmmMessageUtil.getError(e);
			}
		}
	}
	
	public static void copyProperties(BaseVO target, BaseVO data, Model model) throws CmmException{
		try {
			if(model.asMap().get("cmd") != null && !model.asMap().get("cmd").equals("")){
					CmmBeanUtils.copyProperties(target, model.asMap());
							
			}else{
				CmmBeanUtils.copyProperties(target, data);
			}
		} catch (IllegalAccessException e) {
			throw CmmMessageUtil.getError(e);
		} catch (InvocationTargetException e) {
			throw CmmMessageUtil.getError(e);
		}	
	}
}
