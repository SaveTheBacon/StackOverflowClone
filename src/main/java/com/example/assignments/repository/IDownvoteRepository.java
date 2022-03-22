package com.example.assignments.repository;


import com.example.assignments.model.Downvote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDownvoteRepository extends CrudRepository<Downvote, Integer> {
}
