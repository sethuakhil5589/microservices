package com.akhil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.model.Answers;
import com.akhil.model.QuestionsOnly;
import com.akhil.service.QuizServiceImpl;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizServiceImpl service;
	
	@GetMapping("/create/{topic}/{numQ}")
	public ResponseEntity<String> createQuiz(@PathVariable String topic,@PathVariable Integer numQ){
		return new ResponseEntity<>(service.createQuizByTopic(topic, numQ),HttpStatus.CREATED);
	}
	
	@GetMapping("/play/{id}")
	public ResponseEntity<List<QuestionsOnly>> playingQuiz(@PathVariable Integer id){
			return new ResponseEntity<>(service.playByQId(id),HttpStatus.OK);
	}
	
	@PostMapping("/submit")
	public ResponseEntity<Integer> submittingTest(@RequestBody List<Answers> answers){
		
		return new ResponseEntity<>(service.submittingTest(answers),HttpStatus.OK);
	}
}
