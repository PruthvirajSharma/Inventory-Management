package com.sharma.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.model.*;

@Component
public class IssueRawDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Transactional
	public int insert (IssueRaw issueRaw){
		int i = (Integer)this.ht.save(issueRaw);
		return i;
	}
	
	
	public IssueRaw getIssueRaw(int id){
		IssueRaw issueRaw=this.ht.get(IssueRaw.class,id);
		return issueRaw;
	}
	
	
	public List<IssueRaw>getAll(){
		List<IssueRaw> issueRaw = this.ht.loadAll(IssueRaw.class);
		return issueRaw;
	}
	
}
