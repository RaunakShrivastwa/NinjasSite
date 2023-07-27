package com.Teaching.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepositery repositery;

    @Override
    public Student saveStudent(Student student) {
        // TODO Auto-generated method stub
        return this.repositery.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        // TODO Auto-generated method stub
       return this.repositery.findAll();
    }
    
}
