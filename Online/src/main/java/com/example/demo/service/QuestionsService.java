package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Questions;
import com.example.demo.repository.QuestionsRepository;

@Service
public class QuestionsService {
	@Autowired
	QuestionsRepository qrep;
	
	public Questions save(Questions q) {
		return qrep.save(q);
	}
	
	public Questions findOne(int qid) {
		return qrep.getOne(qid);
	}
	public Optional<Questions> findQuestionById(int qid){
		return qrep.findById(qid);
	}
	public void deleteQ(Questions q) {
		qrep.delete(q);
	}

}
