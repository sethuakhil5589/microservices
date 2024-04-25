package com.akhil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akhil.model.Questions;


@Repository
public interface IQuestionsRepo extends JpaRepository<Questions, Integer> {
	List<Questions> findByTopic(String topic);
	@Query(value="SELECT * FROM QUESTIONS q WHERE topic=:topic ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
	List<Questions> findNumQByTopic(String topic, Integer numQ);
}
