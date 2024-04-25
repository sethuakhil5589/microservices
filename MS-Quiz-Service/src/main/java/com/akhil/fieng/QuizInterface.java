package com.akhil.fieng;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.akhil.model.Answers;
import com.akhil.model.QuestionsOnly;

@FeignClient("MS-QUESTIONS-SERVICE")
public interface QuizInterface {
	@GetMapping("/questions/create/{topic}/{numQ}")
	public ResponseEntity<List<Integer>> createQuiz(@PathVariable String topic, @PathVariable Integer numQ);
	
	@PostMapping("/questions/fetchByQNums")
	public ResponseEntity<List<QuestionsOnly>> fetchQuestionsByQuestionNums(@RequestBody List<Integer> questionNumbers);
	
	@PostMapping("/questions/submit")
	public ResponseEntity<Integer> gettingScore(@RequestBody List<Answers> answers);
}
