package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Questions;
import com.example.demo.entity.Test;
import com.example.demo.repository.QuestionsRepository;
import com.example.demo.repository.TestRepository;
import com.example.demo.service.QuestionsService;

@RestController
@RequestMapping("/q")
public class QuestionController {
	@Autowired
	QuestionsService ser;
	@Autowired
	TestRepository trep;
	@Autowired
	QuestionsRepository qrep;
	
	@PostMapping("/question")
	public Questions addQ(@RequestBody Questions q) {
		return ser.save(q);
	}
	
	@PostMapping("/test")
	public Test addT(@RequestBody Test t) {
		return trep.save(t);
	}
	
	@GetMapping("/gett")
	public List<Test> findT() {
		return trep.findAll();
	}
	@GetMapping("/getq")
	public List<Questions> findQ(){
		return qrep.findAll();
	}
	
	@DeleteMapping("/delq/{qid}")
	public ResponseEntity<Questions> deleteQ(@PathVariable(value="qid")int qid)
	{
		Questions q=ser.findOne(qid);
		if(q==null) {
			return ResponseEntity.notFound().build();
		}
		ser.deleteQ(q);
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("/uptquestions/{qid}")
	public ResponseEntity<Questions> updateCity(@PathVariable(value="qid")int qid,@RequestBody Questions q){
		Questions q1=ser.findOne(qid);
		if(q1==null) {
			return ResponseEntity.notFound().build();
		}
		q1.setQtitle(q.getQtitle());
		q1.setOpt1(q.getOpt1());
		q1.setOpt2(q.getOpt2());
		q1.setQans(q.getQans());
		
		Questions q2=ser.save(q1);
		return ResponseEntity.ok().body(q2);
	}
	
	

}
