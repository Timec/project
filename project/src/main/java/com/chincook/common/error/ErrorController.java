package com.chincook.common.error;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	public ErrorController(){
	}
	
    @RequestMapping("/404")
    public String pageNotFound(Locale locale, Model model) {
        return "common/error/404";
    }
    @RequestMapping("/500")
    public String internalServerError(Locale locale, Model model) {
        return "common/error/500";
    }
    @RequestMapping("/502")
    public String badGateway(Locale locale, Model model) {
        return "common/error/502";
    }
}
