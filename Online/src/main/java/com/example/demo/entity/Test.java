package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class Test {
	
	@Id
//	@GeneratedValue
	@Column(name="t_id")
	private int testid;
	private String testtitle;
	
	@OneToMany(targetEntity=Questions.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="tq_fk",referencedColumnName="t_id",insertable = false, updatable = false)
	private Set<Questions> tquestions;
	private long testtotalmarks;
	private long testmarks;
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public String getTesttitle() {
		return testtitle;
	}
	public void setTesttitle(String testtitle) {
		this.testtitle = testtitle;
	}
	public Set<Questions> getTquestions() {
		return tquestions;
	}
	public void setTquestions(Set<Questions> tquestions) {
		this.tquestions = tquestions;
	}
	public long getTesttotalmarks() {
		return testtotalmarks;
	}
	public void setTesttotalmarks(long testtotalmarks) {
		this.testtotalmarks = testtotalmarks;
	}
	public long getTestmarks() {
		return testmarks;
	}
	public void setTestmarks(long testmarks) {
		this.testmarks = testmarks;
	}
	
	
}
