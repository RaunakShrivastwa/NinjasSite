package com.Teaching.Student;

import java.util.List;

import com.Teaching.Student.Student;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudent();
    
}
