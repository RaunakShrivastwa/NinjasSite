package com.Teaching.Test;

import java.util.List;

import com.Teaching.Test.Question;

public interface QuestionService {

    Question saveQuestion(Question question);

    List<Question> allData();

    Question getSingleData(long id);
    
}
