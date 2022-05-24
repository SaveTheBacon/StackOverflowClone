package com.example.assignments.repository;

import com.example.assignments.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPostRepository  extends JpaRepository<Post, Integer> {

}
