package com.example.assignments.controller;


import com.example.assignments.dto.AnswerDTO;
import com.example.assignments.model.Answer;
import com.example.assignments.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<Answer> getAnswers(){
        return answerService.getAllAnswers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAnswer")
    @ResponseBody
    public Answer getAnswer(@RequestParam(name = "id") Integer id){
        return answerService.getAnswer(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAnswer")
    @ResponseBody
    public String deleteAnswer(@RequestParam(name = "id") Integer id) {
        return answerService.deleteAnswer(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveAnswer")
    @ResponseBody
    public Answer saveAnswer(@RequestBody AnswerDTO answerDTO) {
        Answer auxAnswer = new Answer(answerDTO);


        return answerService.saveAnswer(auxAnswer);
    }

    @RequestMapping(method = RequestMethod.PUT  , value = "/updateAnswer")
    @ResponseBody
    public Answer updateAnswer(@RequestBody AnswerDTO answerDTO) {
        System.out.printf("va rog stop");
        Answer answer = new Answer(answerDTO, "SCUZE");
        return answerService.updateAnswer(answer);
    }
}
