package com.sharma.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.model.Raw;

@Component
public class RawDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Transactional
	public int insert (Raw raw){
		int i = (Integer)this.ht.save(raw);
		return i;
	}
	
	public Raw getRaw(int id){
		Raw raw=this.ht.get(Raw.class,id);
		return raw;
	}
	
	
	public List<Raw>getAll(){
		List<Raw> raw = this.ht.loadAll(Raw.class);
		return raw;
	}
	
	@Transactional
	public void delete(int id){
		Raw raw = this.ht.get(Raw.class,id);
		this.ht.delete(raw);
	}

	@Transactional
	public void updateRaw(int id,int quantity)
	{
		Raw rm=ht.get(Raw.class, id);
		int rq=rm.getQuantity();
		int temp=rq+quantity;
		rm.setQuantity(temp);
		ht.update(rm);
	}
	
	@Transactional
	public void updateIssueRaw(int id,int quantity){
		Raw rm=ht.get(Raw.class, id);
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
