package com.akhil.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.dao.IQuizRepo;
import com.akhil.fieng.QuizInterface;
import com.akhil.model.Answers;
import com.akhil.model.QuestionsOnly;
import com.akhil.model.Quiz;
@Service
public class QuizServiceImpl implements IQuizService {
	
	@Autowired
	private QuizInterface quizFeign;
	@Autowired
	private IQuizRepo quizRepo;
	
	@Override
	public String createQuizByTopic(String topic, Integer numQ) {
		List<Integer> questionIds = quizFeign.createQuiz(topic, numQ).getBody();
		Quiz quiz=new Quiz();
		quiz.setQuestionIds(questionIds);
		quizRepo.save(quiz);
		return "Successfully created" ;
	}

	@Override
	public List<QuestionsOnly> playByQId(Integer id){
		 List<Integer> questionNumbers = quizRepo.findById(id).get().getQuestionIds();
		 
		 return quizFeign.fetchQuestionsByQuestionNums(questionNumbers).getBody();
		}

	@Override
	public Integer submittingTest(List<Answers> answers) {
		return quizFeign.gettingScore(answers).getBody();
	}
	
}


