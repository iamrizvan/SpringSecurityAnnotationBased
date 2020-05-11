package org.studyeasy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("appController")
public class AppController {

	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView model = new ModelAndView("admin");
		return model;
	}

	@RequestMapping("/user")
	public ModelAndView user() {
		ModelAndView model = new ModelAndView("user");
		return model;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	// ACCESS DENIED PAGE Step #3 add request mapping method for handling access denied requests
	// ACCESS DENIED PAGE Step #4 add a JSP page with name "403.jsp"
	@RequestMapping("/403")
	public ModelAndView access403() {
		ModelAndView model = new ModelAndView("403");
		return model;
	}
	
}