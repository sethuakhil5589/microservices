package com.akhil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.dao.IQuestionsRepo;
import com.akhil.model.Answers;
import com.akhil.model.Questions;
import com.akhil.model.QuestionsOnly;


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

	@Override
	public List<Integer> createQuizByNumQTopic(String topic, Integer numQ) {
		List<Questions> questions = questionsRepo.findNumQByTopic(topic, numQ);
		List<Integer> questionNumbers=new ArrayList<>();
		for(Questions question:questions) {
			questionNumbers.add(question.getQuestionId());
		}
		return questionNumbers;
	}

	@Override
	public List<QuestionsOnly> fetchByQNums(List<Integer> questionNums) {
		List<QuestionsOnly> questionsList=new ArrayList<>();
		for (Integer num:questionNums) {
			Questions question = questionsRepo.findById(num).get();
			QuestionsOnly questionOnly=new QuestionsOnly(question.getQuestionId(),question.getQuestion(),
					question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
			questionsList.add(questionOnly);
		}
		return questionsList;
	}

	@Override
	public Integer getScore(List<Answers> answers) {
		Integer result=0;
		for(Answers answer:answers) {
			Questions question = questionsRepo.findById(answer.getId()).get();
			if(question.getAnswer().equals(answer.getAnswer()))
				result++;
		}
		return result;
	}
	
}
