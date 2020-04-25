package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Questions")
public class Questions {
	
	@Id
	@Column(name="qid")
	private int qid;
	private String qtitle;
	//private HashMap<Integer,String> qoptions;
	private String opt1;
	private String opt2;
	private int qans;
	private long qmarks;
	//changes made at 25-04-2020 night
	/*private Test testid;
	
	
	public Test getTestid() {
		return testid;
	}
	public void setTestid(Test testid) {
		this.testid = testid;
	}
	*/
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	/*
	public HashMap<Integer, String> getQoptions() {
		return qoptions;
	}
	public void setQoptions(HashMap<Integer, String> qoptions) {
		this.qoptions = qoptions;
	}*/
	public int getQans() {
		return qans;
	}
	public void setQans(int qans) {
		this.qans = qans;
	}
	public long getQmarks() {
		return qmarks;
	}
	public void setQmarks(long qmarks) {
		this.qmarks = qmarks;
	}
	
	
}
