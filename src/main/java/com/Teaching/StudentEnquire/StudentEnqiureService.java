package com.Teaching.StudentEnquire;

import java.util.List;

import com.Teaching.StudentEnquire.StudentEnqiure;

public interface StudentEnqiureService {

    StudentEnqiure saveStudent(StudentEnqiure student);
    List<StudentEnqiure> getAllStudent();
    
}
