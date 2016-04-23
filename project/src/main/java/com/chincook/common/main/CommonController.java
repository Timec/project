package com.chincook.common.main;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	public CommonController(){
	}
	
    @RequestMapping("/")
    public String main(Locale locale, Model model) {
        return "home";
    }
}
