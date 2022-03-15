package com.example.assignments.repository;

import com.example.assignments.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends CrudRepository<Answer, Integer> {
}
