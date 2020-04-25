package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Integer>{
/*
	@Modifying
	@Query("UPDATE Questions q set q.testid=?1 where qid=?2")
	void addQtoTrail(int testid,int qid);
	*/
}
