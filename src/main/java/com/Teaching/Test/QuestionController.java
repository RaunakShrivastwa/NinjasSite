package com.Teaching.Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Teaching.Test.Question;
import com.Teaching.Test.QuestionService;

@RestController
public class QuestionController {
    
    @Autowired
    private QuestionService service;

    @PostMapping("/question")
    public Question savQuestion(@RequestBody Question question){
        return this.service.saveQuestion(question);
    }

    @GetMapping("question/{id}")
    public Question getSinglQuestion(@PathVariable long id){
        return this.service.getSingleData(id);
    }

    @GetMapping("/question")
    public List<Question> getAllQuestions(){
        return this.service.allData();
    }
}
