package com.sharma.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(){
		return "index";
	}
	
	@RequestMapping("/login")
	public String home(){
		return "index";
	}
	@RequestMapping("/failure")
	public String failed(){
		return "failure";
	}
	
	
	@RequestMapping(path ="/dashboard",method = RequestMethod.POST)
	public String homepage(HttpServletRequest request){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.equals("sharma@gmail.com") && password.equals("sharma")){
			return "dashboard";
		}
		else
		{
			return "failure";
		}
	}
	
}
