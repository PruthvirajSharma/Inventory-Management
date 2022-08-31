package com.sharma.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import com.sharma.dao.*;
import com.sharma.model.*;

@Controller
public class ProcessController {

	
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	ProcessedDao processDao = (ProcessedDao)context.getBean("processedDao");
	IssueProcessDao issueProcessDao = (IssueProcessDao)context.getBean("issueProcessDao");
	
	
	@RequestMapping("/addProcessPage")
	public String addProcess(){
		return "processPage";
	}
	
	@RequestMapping(path="/addProcess")
	public RedirectView insertProcess(@ModelAttribute Processed process,HttpServletRequest request)
	{
		processDao.insert(process);
		RedirectView rv  = new RedirectView();
		rv.setUrl(request.getContextPath()+"/viewProcess");
		return rv;
	}
	
	@RequestMapping("/viewProcess")
	public  String viewProcessPage(Model m){
		System.out.println("I'm from view");
		List<Processed> process= processDao.getAll();
		m.addAttribute("process",process);
		return "viewProcess";
	}
	
	@RequestMapping(path="/deleteProcess/{id}",method=RequestMethod.GET)
	public RedirectView deleteProcess(@PathVariable("id")int id,HttpServletRequest request){
		processDao.delete(id);
		RedirectView rv  = new RedirectView();
		rv.setUrl(request.getContextPath()+"/viewProcess");
		return rv;
	}
	
	@RequestMapping("/updateProcessPage")
	public String updateProcess()
	{
		return "updateProcessPage";
	}
	
	@RequestMapping(path="/updateProcess",method=RequestMethod.POST)
	public String updateProcessMaterial(HttpServletRequest request)
	{
		
		int id=Integer.parseInt(request.getParameter("id"));
		int quant=Integer.parseInt(request.getParameter("quantity"));
		processDao.updateProcess(id, quant);
		return "dashboard";
	}
	
	
	
	@RequestMapping("/issueProcessPage")
	public String issueProcess(){
		return "issueProcessPage";
	}
	
	
	@RequestMapping(path="/issueProcess",method=RequestMethod.POST)
	public RedirectView issueProcessMaterial(@ModelAttribute IssueProcess issueProcess,HttpServletRequest request){
		RedirectView rv  = new RedirectView();
		int pid = issueProcess.getPid();
		
		try
		{
			Processed rm=processDao.getProcess(pid);
			int aQuantity = rm.getQuantity();
			int iQuantity = issueProcess.getQuantity();
			issueProcess.setName(rm.getName());
			if(aQuantity >= iQuantity){
				int temp = aQuantity-iQuantity;
				issueProcessDao.insert(issueProcess);
				rm.setQuantity(temp);
				processDao.updateIssueProcess(pid, temp);
				rv.setUrl(request.getContextPath()+"/viewIssueProcessLog");
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
	
	
	@RequestMapping("/viewIssueProcessLog")
	public String viewIssueRawLog(Model m){
		System.out.println("i'm from process log");
		List<IssueProcess> issueProcess = issueProcessDao.getAll();
		m.addAttribute("issueProcess",issueProcess);
		return "viewIssueProcessLog";
	}
	
}
