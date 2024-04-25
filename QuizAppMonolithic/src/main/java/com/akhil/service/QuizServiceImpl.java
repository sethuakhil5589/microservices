package com.akhil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.dao.IQuestionsRepo;
import com.akhil.dao.IQuizRepo;
import com.akhil.model.Questions;
import com.akhil.model.QuestionsOnly;
import com.akhil.model.Quiz;
@Service
public class QuizServiceImpl implements IQuizService {

	@Autowired
	private IQuestionsRepo questionsRepo;
	@Autowired
	private IQuizRepo quizRepo;
	
	@Override
	public String createQuizByTopic(String topic, Integer numQ) {
		Quiz quiz=new Quiz();
		quiz.setQuestions(questionsRepo.findNumQByTopic(topic, numQ));
		quizRepo.save(quiz);
		return "Successfully created" ;
	}

	@Override
	public List<QuestionsOnly> playByQId(Integer id){
		 List<Questions> questions = quizRepo.findById(id).get().getQuestions();
		 QuestionsOnly questionsOnly=new QuestionsOnly();
		 List<QuestionsOnly> queList=new ArrayList<>();
		 for(Questions question:questions) {
			 questionsOnly.setQuestionId(question.getQuestionId());
			 questionsOnly.setQuestion(question.getQuestion());
			 questionsOnly.setOption1(question.getOption1());
			 questionsOnly.setOption2(question.getOption2());
			 questionsOnly.setOption3(question.getOption3());
			 questionsOnly.setOption4(question.getOption4());
			 queList.add(questionsOnly);
		 }
		 return queList;
		}

	@Override
	public String submittingTest(List<String> answers,Integer id) {
		List<Questions> questions = quizRepo.findById(id).get().getQuestions();
		Integer i=0;
		Integer result=0;
		for(Questions question:questions) {
			if(question.getAnswer().equals(answers.get(i))) {
				result++;
				i++;
			}
			else
				i++;
			
		}
		return "Score for the student is: "+result;
	}
	}


