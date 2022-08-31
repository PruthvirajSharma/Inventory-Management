package com.sharma.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.model.*;

@Component
public class IssueProcessDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Transactional
	public int insert (IssueProcess issueProcess){
		int i = (Integer)this.ht.save(issueProcess);
		return i;
	}
	
	
	public IssueProcess getIssueProcess(int id){
		IssueProcess issueProcess=this.ht.get(IssueProcess.class,id);
		return issueProcess;
	}
	
	
	public List<IssueProcess>getAll(){
		List<IssueProcess> issueProcess = this.ht.loadAll(IssueProcess.class);
		return issueProcess;
	}
}
