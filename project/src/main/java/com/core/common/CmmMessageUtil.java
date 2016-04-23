package com.core.common;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.core.common.vo.GenericVO;
import com.core.constants.MessageConstants;
import com.core.exception.CmmException;

public class CmmMessageUtil {
	public static CmmException getError(String code){
		return new CmmException(code);
	}
	
	public static CmmException getError(Exception e){
		return new CmmException(MessageConstants.defaultErrorCode, e);
	}
	
	public static CmmException getError(String code, Exception e){
		if(code != null){
			return new CmmException(code, e);
		}
		return new CmmException(MessageConstants.defaultErrorCode, e);
	}
	
	public static void saveError(Model model, String message){
		model.addAttribute("msg", message);
	}
	public static void saveError(Model model, String message, boolean popup_yn){
		model.addAttribute("msg", message);
	}
	public static void saveSuccess(Model model, String message){
		model.addAttribute("msg", message);
	}
	public static void saveSuccess(Model model, String message, boolean popup_yn){
		model.addAttribute("msg", message);
	}
	
	public static void saveError(GenericVO vo, String message){
		vo.setMsg(message);
	}
	public static void saveError(GenericVO vo, String message, boolean popup_yn){
		vo.setMsg(message);
	}
	public static void saveSuccess(GenericVO vo, String message){
		vo.setMsg(message);
	}
	public static void saveSuccess(GenericVO vo, String message, boolean popup_yn){
		vo.setMsg(message);
	}
	
	public static void saveError(RedirectAttributes redirectAttributes, String message){
		redirectAttributes.addFlashAttribute("msg", message);
	}
	public static void saveError(RedirectAttributes redirectAttributes, String message, boolean popup_yn){
		redirectAttributes.addFlashAttribute("msg", message);
	}
	public static void saveSuccess(RedirectAttributes redirectAttributes, String message){
		redirectAttributes.addFlashAttribute("msg", message);
	}
	public static void saveSuccess(RedirectAttributes redirectAttributes, String message, boolean popup_yn){
		redirectAttributes.addFlashAttribute("msg", message);
	}
}
