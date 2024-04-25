package com.akhil.service;

import java.util.List;

import com.akhil.model.QuestionsOnly;

public interface IQuizService {
	String createQuizByTopic(String topic,Integer numQ);
	List<QuestionsOnly> playByQId(Integer id);
	String submittingTest(List<String> answers,Integer id);
}
