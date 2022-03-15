package com.example.assignments.repository;

import com.example.assignments.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPostRepository  extends CrudRepository<Post, Integer> {
}
