package com.example.assignments.repository;


import com.example.assignments.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends CrudRepository<Tag, Integer> {
}
