package com.sharma.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import com.sharma.dao.*;
import com.sharma.model.*;


@Controller
public class RawController {
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	RawDao rawDao = (RawDao)context.getBean("rawDao");
	IssueRawDao issueRawDao = (IssueRawDao)context.getBean("issueRawDao");
	
	
	@RequestMapping("/addRawPage")
	public String addRaw(){
		return "dashboard";
	}
	
	@RequestMapping(path="/addRaw")
	public RedirectView insertRaw(@ModelAttribute Raw raw,HttpServletRequest request)
	{
		rawDao.insert(raw);
		RedirectView rv  = new RedirectView();
		rv.setUrl(request.getContextPath()+"/viewRaw");
		return rv;
	}
	
	@RequestMapping("/viewRaw")
	public  String viewRawPage(Model m){
		System.out.println("I'm from view");
		List<Raw> raw= rawDao.getAll();
		m.addAttribute("raw",raw);
		return "viewRaw";
	}
	
	@RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
	public RedirectView delete(@PathVariable("id")int id,HttpServletRequest request){
		rawDao.delete(id);
		RedirectView rv  = new RedirectView();
		rv.setUrl(request.getContextPath()+"/viewRaw");
		return rv;
	}
	
	@RequestMapping("/updateRawPage")
	public String updateRaw()
	{
		return "updateRaw";
	}
	
	@RequestMapping(path="/updateRaw",method=RequestMethod.POST)
	public String updateRawMaterial(HttpServletRequest request)
	{
		
		int id=Integer.parseInt(request.getParameter("id"));
		int quant=Integer.parseInt(request.getParameter("quantity"));
		rawDao.updateRaw(id, quant);
		return "dashboard";
	}
	
	
	@RequestMapping("/issueRawPage")
	public String issueRaw(){
		return "issueRawPage";
	}
	
	
	@RequestMapping(path="/issueRaw",method=RequestMethod.POST)
	public RedirectView issueRawMaterial(@ModelAttribute IssueRaw issueRaw,HttpServletRequest request){
		RedirectView rv  = new RedirectView();
		int pid = issueRaw.getPid();
		
		try
		{
			Raw rm=rawDao.getRaw(pid);
			int aQuantity = rm.getQuantity();
			int iQuantity = issueRaw.getQuantity();
			issueRaw.setName(rm.getName());
			if(aQuantity >= iQuantity){
				int temp = aQuantity-iQuantity;
				issueRawDao.insert(issueRaw);
				rm.setQuantity(temp);
				rawDao.updateIssueRaw(pid, temp);
				rv.setUrl(request.getContextPath()+"/viewIssueRawLog");
				return rv;
			}
			else{
				rv.setUrl(request.getContextPath()+"/failure");
				return rv;
			}
			
		}
		catch(Exception e)
		{
			rv.setUrl(request.getContextPath()+"/failure");
			return rv;
			
		}
	}
	
	
	@RequestMapping("/viewIssueRawLog")
	public String viewIssueRawLog(Model m){
		System.out.println("i'm from raw log");
		List<IssueRaw> issueRaw = issueRawDao.getAll();
		m.addAttribute("issueRaw",issueRaw);
		return "viewIssueRawLog";
	}
	
}
