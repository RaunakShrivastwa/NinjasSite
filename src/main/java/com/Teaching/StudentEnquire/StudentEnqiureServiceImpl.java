package com.Teaching.StudentEnquire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentEnqiureServiceImpl implements StudentEnqiureService{

    @Autowired
    private StudentEnqiureRepositery repositery;

    @Override
    public StudentEnqiure saveStudent(StudentEnqiure student) {
        // TODO Auto-generated method stub
        return this.repositery.save(student);
       
    }

    @Override
    public List<StudentEnqiure> getAllStudent() {
        return this.repositery.findAll();
        
    }
    
}
