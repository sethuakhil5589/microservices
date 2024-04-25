package com.akhil.service;

import java.util.List;

import com.akhil.model.Questions;

public interface IQuestionsService {
	List<Questions> fetchQuestions();
	String savingData(Questions question);
	List<Questions> fetchingByTopic(String topic);
}
