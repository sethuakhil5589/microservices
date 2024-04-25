package com.akhil.service;

import java.util.List;

import com.akhil.model.Answers;
import com.akhil.model.Questions;
import com.akhil.model.QuestionsOnly;



public interface IQuestionsService {
	List<Questions> fetchQuestions();
	String savingData(Questions question);
	List<Questions> fetchingByTopic(String topic);
	List<Integer> createQuizByNumQTopic(String topic, Integer numQ);
	List<QuestionsOnly> fetchByQNums(List<Integer> questionNums);
	Integer getScore(List<Answers> answers);
}
