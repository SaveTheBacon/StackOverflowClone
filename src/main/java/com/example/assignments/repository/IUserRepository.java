package com.example.assignments.repository;

import com.example.assignments.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
}
