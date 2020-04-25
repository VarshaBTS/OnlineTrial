package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.demo.service.TestService;

@RestController
@RequestMapping("/q")
public class QuestionController {
	@Autowired
	QuestionsService ser;
	@Autowired
	TestService tser;
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
	
	@DeleteMapping("/delt/{testid}")
	public ResponseEntity<Questions> deleteT(@PathVariable(value="testid")int testid)
	{
		Optional<Test> t=trep.findById(testid);
		if(t==null) {
			return ResponseEntity.notFound().build();
		}
		trep.deleteById(testid);
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("/uptquestions/{qid}")
	public ResponseEntity<Questions> updateQ(@PathVariable(value="qid")int qid,@RequestBody Questions q){
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
	
	@PutMapping("/upttest/{testid}")
	public ResponseEntity<Test> updateT(@PathVariable(value="testid")int testid,@RequestBody Test t){
		Test t1=tser.findOne(testid);
		if(t1==null) {
			return ResponseEntity.notFound().build();
		}
		t1.setTesttitle(t.getTesttitle());
		t1.setTestmarks(t.getTestmarks());
		t1.setTesttotalmarks(t.getTesttotalmarks());
		
		Test t2=trep.save(t1);
		return ResponseEntity.ok().body(t2);
	}
	
	
	/*
	//add questions to test
	@PostMapping("/{testid}/{qid}")
	public void addQtoTest(@PathVariable(value="testid")int testid,@PathVariable(value="qid")int qid)
	{
		Test t = null;
		List<Questions> l = null;
		Questions q=qrep.getOne(qid);
		l.add(q);
		t.setTquestions(l);
	}
	
	@PostMapping("/{testid}/{qid}")
	public void addqttrial(@PathVariable(value="testid")int testid,@PathVariable(value="qid")int qid)
	{
		Questions q=qrep.getOne(qid);
		Test t=trep.getOne(testid);
		
		//Test t = null;
		List<Questions> l = null;
		l.add(q);
		t.setTquestions(l);
	}
	*/

	/*
	@PostMapping("/{testid}/{qid}")
	public Questions createT(@PathVariable(value="testid")int testid,
			@PathVariable(value="qid")int qid)
	{
		Questions q=qrep.getOne(qid);
		
		Test t=trep.getOne(testid);
		q.setTest(t);
		return q;
		
		//q.setQid(rd.get(qid));
	}
	*/
	

}
