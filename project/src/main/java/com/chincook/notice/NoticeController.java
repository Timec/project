package com.chincook.notice;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.core.common.CmmController;
import com.core.common.CmmMessageUtil;
import com.core.exception.CmmException;
import com.core.util.CmmBeanUtils;

@Controller
public class NoticeController extends CmmController{
	@Autowired
	NoticeService sysCodeService;
	
	public NoticeController(){
	}
	
	@RequestMapping(value="/notice/list/{cmd}")
	public String codes(
			Locale locale, Model model,
			@PathVariable String cmd,
			@ModelAttribute("NoticeVO") NoticeVO vo
			) throws CmmException{
		NoticeVO codeVo = new NoticeVO();
		try{
			CmmBeanUtils.copyProperties(codeVo, vo, model);
			
			codeVo.setForwardUrl("notice/list");
			
			model.addAttribute("NoticeVO", codeVo);
		}catch(CmmException e){
			logger.debug("CmmException", e);
			CmmMessageUtil.saveError(model, getMessage(e.getCode(), locale));
			return codeVo.getErrorUrl();
		}
		
		return codeVo.getUrl();
	}
	
	@RequestMapping(value="/notice/detail/{cmd}")
	public String code(
			Locale locale, Model model,
			@PathVariable String cmd,
			@ModelAttribute("NoticeVO") NoticeVO vo,
			RedirectAttributes redirectAttributes
			) throws CmmException{
		NoticeVO codeVo = new NoticeVO();
		try{
			CmmBeanUtils.copyProperties(codeVo, vo, model);
			switch(cmd){
				case "view":
					codeVo.setForwardUrl("notice/edit");
					
					codeVo.setCmd("edit");
					model.addAttribute("NoticeVO", codeVo);
					break;
				case "input" :
					codeVo.setForwardUrl("notice/edit");
					
					codeVo.setCmd("input");
					model.addAttribute("NoticeVO", codeVo);
					break;
				default:
			}
		}catch(CmmException e){
			logger.debug("CmmException", e);
			CmmMessageUtil.saveError(model, getMessage(e.getCode(), locale));
			return codeVo.getErrorUrl();
		}
		return codeVo.getUrl();
	}
	
	@RequestMapping(value="/notice/listData/{cmd}", method=RequestMethod.GET)
	@ResponseBody 
	public NoticeVO listData(
			Locale locale, Model model,
			@PathVariable String cmd,
			@ModelAttribute("NoticeVO") NoticeVO vo
			)throws CmmException{
		NoticeVO codeVo = new NoticeVO();
		try{
			CmmBeanUtils.copyProperties(codeVo, vo);
			switch(cmd){
				case "list" :
					System.out.println("-----------------list");
					codeVo = sysCodeService.list(codeVo);
					break;
				case "delete" :
					int cnt = sysCodeService.delete(codeVo);
					CmmMessageUtil.saveSuccess(codeVo, getMessage("success.message.delete", locale, cnt));
					break;
				default:
			}
		}catch(CmmException e){
			logger.debug("CmmException", e);
			CmmMessageUtil.saveError(codeVo, getMessage(e.getCode(), locale));
		} catch (IllegalAccessException e) {
			logger.debug("CmmException", e);
			CmmMessageUtil.saveError(codeVo, getMessage(locale));
		} catch (InvocationTargetException e) {
			logger.debug("CmmException", e);
			CmmMessageUtil.saveError(codeVo, getMessage(locale));
		}
		return codeVo;
	}
	
	@RequestMapping(value="/notice/detailData/{cmd}", method={RequestMethod.POST, RequestMethod.GET})
	@ResponseBody 
	public NoticeVO detailData(
			Locale locale, Model model,
			@PathVariable String cmd,
			@ModelAttribute("NoticeVO") NoticeVO vo
			)throws CmmException{
		NoticeVO codeVo = new NoticeVO();
		try{
			CmmBeanUtils.copyProperties(codeVo, vo, model);
			switch(cmd){
				case "view" :
					codeVo = sysCodeService.edit(codeVo);
					
					codeVo.setCmd("edit");
					break;
				case "update" :
					sysCodeService.update(codeVo);
					
					codeVo.setCmd("edit");
					CmmMessageUtil.saveSuccess(codeVo, "Update Success", true);
					break;
				case "insert" :
					sysCodeService.insert(codeVo);
					
					codeVo.setCmd("edit");
					CmmMessageUtil.saveSuccess(codeVo, "Insert Success", true);
					break;
				default:
			}
		}catch(CmmException e){
			logger.debug("CmmException", e);
			CmmMessageUtil.saveError(codeVo, getMessage(e.getCode(), locale));
		}
		return codeVo;
	}
}
