
        package com.Teaching.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Teaching.Student.Student;
import com.Teaching.Student.StudentRepositery;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
    
    @Autowired
    private CourseService service;

    @Autowired
    private CourseRepositery repositery;

    @Autowired
    private StudentRepositery repositery1;

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course){
       
        return this.service.saveCourse(course);
    }

    @GetMapping("/course")
   public List<Course> allCourses(){
        return this.repositery.findAll();
    }

    @GetMapping("/getSingle/{id}")
    public Student getStudentOne(@PathVariable String id){
        return this.repositery1.findById(id).get();
    }
}
