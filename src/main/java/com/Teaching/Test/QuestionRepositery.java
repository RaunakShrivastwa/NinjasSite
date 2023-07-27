package com.Teaching.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Teaching.Test.Question;

@Repository
public interface QuestionRepositery extends JpaRepository<Question,Long>{
    
}
