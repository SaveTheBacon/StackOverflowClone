package com.example.assignments.service;

import com.example.assignments.model.Answer;
import com.example.assignments.repository.IAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    IAnswerRepository iAnswerRepository;


    public List<Answer> getAllAnswers(){
        return (List<Answer>) iAnswerRepository.findAll();
    }

    public Answer getAnswer(Integer ID){
        Optional<Answer> answer = iAnswerRepository.findById(ID);
        return answer.orElse(null);
    }

    public String deleteAnswer(Integer ID){
        try{
            iAnswerRepository.delete(this.getAnswer(ID));
            return "Delete successful";
        }
        catch (Exception e){
            return "Deletion failed";
        }
    }

    public Answer saveAnswer(Answer answer){
        return iAnswerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer){
        return iAnswerRepository.save(answer);
    }


}
