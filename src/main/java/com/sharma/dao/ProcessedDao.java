package com.sharma.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.model.*;

@Component
public class ProcessedDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Transactional
	public int insert (Processed process){
		int i = (Integer)this.ht.save(process);
		return i;
	}
	
	public Processed getProcess(int id){
		Processed process=this.ht.get(Processed.class,id);
		return process;
	}
	
	
	public List<Processed>getAll(){
		List<Processed> process = this.ht.loadAll(Processed.class);
		return process;
	}
	
	@Transactional
	public void delete(int id){
		Processed process = this.ht.get(Processed.class,id);
		this.ht.delete(process);
	}
	
	@Transactional
	public void updateProcess(int id,int quantity)
	{
		Processed rm=ht.get(Processed.class, id);
		int rq=rm.getQuantity();
		int temp=rq+quantity;
		rm.setQuantity(temp);
		ht.update(rm);
	}
	
	@Transactional
	public void updateIssueProcess(int id,int quantity){
		Processed rm=ht.get(Processed.class, id);
		rm.setQuantity(quantity);
		ht.update(rm);
	}

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
}
