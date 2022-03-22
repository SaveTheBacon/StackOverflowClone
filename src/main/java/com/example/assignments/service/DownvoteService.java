package com.example.assignments.service;


import com.example.assignments.repository.IDownvoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownvoteService {

    @Autowired
    IDownvoteRepository iDownvoteRepository;
}
