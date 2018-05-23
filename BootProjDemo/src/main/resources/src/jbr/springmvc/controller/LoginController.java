package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbr.springmvc.model.LoginBean;
import jbr.springmvc.model.UserBean;
import jbr.springmvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new LoginBean());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request,HttpServletResponse response,
			                         @ModelAttribute("login") LoginBean login) {
		ModelAndView mav = null;
		UserBean user = userService.validateUser(login);
		if (null != user) {
			mav = new ModelAndView("welcome");
			mav.addObject("firstname", user.getFirstname());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}
}