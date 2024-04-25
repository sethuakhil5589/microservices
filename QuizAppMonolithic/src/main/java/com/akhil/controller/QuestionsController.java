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

import com.akhil.model.Questions;
import com.akhil.service.QuestionServiceImpl;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

	@Autowired
	private QuestionServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Questions>> fetchingQuestions(){
		return new ResponseEntity<>(service.fetchQuestions(),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> savingData(@RequestBody Questions question){
		return new ResponseEntity<>(service.savingData(question),HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch/{topic}")
	public ResponseEntity<List<Questions>> fetchingQuestionsByTopic(@PathVariable String topic){
		return new ResponseEntity<>(service.fetchingByTopic(topic),HttpStatus.OK);
	}
}
