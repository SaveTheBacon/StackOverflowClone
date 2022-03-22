package com.example.assignments.repository;


import com.example.assignments.model.TagLinker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagLinkerRepository extends CrudRepository<TagLinker, Integer> {
}
