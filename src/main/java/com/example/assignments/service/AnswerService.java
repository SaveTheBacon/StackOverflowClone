package com.example.assignments.service;

import com.example.assignments.model.Answer;
import com.example.assignments.repository.IAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    @Autowired
    IAnswerRepository iAnswerRepository;


    public List<Answer> getAllAnswers(){
        List<Answer> aux = (List<Answer>) iAnswerRepository.findAll();

        aux.stream().sorted(new Comparator<Answer>() {
            @Override
            public int compare(Answer answer, Answer t1) {
                return answer.getScore().compareTo(t1.getScore());
            }
        }).collect(Collectors.toList());
        Collections.reverse(aux);
        return aux;
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
