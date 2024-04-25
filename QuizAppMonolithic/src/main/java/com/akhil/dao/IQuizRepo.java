package com.akhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.model.Quiz;

public interface IQuizRepo extends JpaRepository<Quiz, Integer> {

}
