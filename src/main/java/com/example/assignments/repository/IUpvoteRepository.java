package com.example.assignments.repository;


import com.example.assignments.model.Upvote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUpvoteRepository extends CrudRepository<Upvote, Integer> {
}
