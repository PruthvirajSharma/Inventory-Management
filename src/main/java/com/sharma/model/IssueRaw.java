package com.sharma.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class IssueRaw {
	@Id
	private int id;
	private String name;
	private int quantity;
	private String issuer_name;
	private int pid;
	private String datee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getIssuer_name() {
		return issuer_name;
	}
	public void setIssuer_name(String issuer_name) {
		this.issuer_name = issuer_name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDatee() {
		return datee;
	}
	public void setDatee(String datee) {
		this.datee = datee;
	}
	@Override
	public String toString() {
		return "IssueRaw [id=" + id + ", name=" + name + ", quantity=" + quantity + ", issuer_name=" + issuer_name
				+ ", pid=" + pid + ", datee=" + datee + "]";
	}
	public IssueRaw(int id, String name, int quantity, String issuer_name, int pid, String datee) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.issuer_name = issuer_name;
		this.pid = pid;
		this.datee = datee;
	}
	public IssueRaw() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
