package com.akhil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.dao.IQuestionsRepo;
import com.akhil.model.Questions;

@Service
public class QuestionServiceImpl implements IQuestionsService {

	@Autowired
	private IQuestionsRepo questionsRepo;
	
	@Override
	public List<Questions> fetchQuestions() {
		return questionsRepo.findAll();
	}

	@Override
	public String savingData(Questions question) {
		return "Data Saved with id: "+questionsRepo.save(question).getQuestionId();
	}

	@Override
	public List<Questions> fetchingByTopic(String topic) {
		return questionsRepo.findByTopic(topic);
	}
	
}
