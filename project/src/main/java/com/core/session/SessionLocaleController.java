package com.core.session;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SessionLocaleController {
	
	@Autowired
    SerializableResourceBundleMessageSource messageSource;
	
	@RequestMapping("/changeLocale")
	public String changeLocale(
			@RequestParam(required = false) String lang, 
			Model model, 
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes redirectAttributes){
		HttpSession session = request.getSession();
		Locale locales = null;
		if(lang != null && lang.equalsIgnoreCase("en")){
			locales = Locale.ENGLISH;
		}else{
			locales = Locale.KOREAN;
		}
		session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locales);
		
		Enumeration<?> enumeration = request.getParameterNames();
		
		String key = "";
		String[] values = null;
		
		while(enumeration.hasMoreElements()){
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if(values != null && !key.equals("_csrf")){
				redirectAttributes.addFlashAttribute(key, (values.length > 1) ? values:values[0]);
			}
		}
		
		String url = request.getHeader("referer");
		
		url = url.replaceAll("(/ko/)|(/en/)", "/"+lang+"/");
		url = "redirect:" + url;
		
		return url;
	}

	@RequestMapping("/messageBundle")
	@ResponseBody
	public Properties messageBundle(
			@RequestParam(required = false) String lang){
		Locale locales = null;
		if(lang != null && lang.equalsIgnoreCase("en")){
			locales = Locale.ENGLISH;
		}else{
			locales = Locale.KOREAN;
		}

        return messageSource.getAllProperties(locales);
	}
}
