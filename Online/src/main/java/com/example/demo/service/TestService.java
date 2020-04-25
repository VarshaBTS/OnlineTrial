package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Questions;
import com.example.demo.entity.Test;
import com.example.demo.repository.TestRepository;
@Service
public class TestService {
	@Autowired
	TestRepository trep;
	
	public Test findOne(int qid) {
		return trep.getOne(qid);
	}
	public void deleteT(Test t) {
		trep.delete(t);
	}
}
