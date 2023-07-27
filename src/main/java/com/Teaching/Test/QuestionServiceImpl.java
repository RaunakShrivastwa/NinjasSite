package com.Teaching.Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepositery repositery;

    @Override
    public Question saveQuestion(Question question) {
        return this.repositery.save(question);
    }

    @Override
    public List<Question> allData() {
        return this.repositery.findAll();
    }

    @Override
    public Question getSingleData(long id) {
       return this.repositery.findById(id).get();
    }
    
}
