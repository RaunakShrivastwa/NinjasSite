
        package com.Teaching.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Teaching.Student.Student;
import com.Teaching.Student.StudentRepositery;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CourseController {
    
    @Autowired
    private CourseService service;

    @Autowired
    private CourseRepositery repositery;

    @Autowired
    private StudentRepositery studentRepo;

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
    public Course getStudentOne(@PathVariable Long id){
        return this.repositery.findById(id).get();
    }

    @GetMapping("/getStudentData/{id}")
    public Student getStudent(@PathVariable String id){
        return this.studentRepo.findById(id).get();
    }

    @DeleteMapping("/deleteCourse/{id}")
    public void deleteData(@PathVariable Long id){
        this.repositery.deleteById(id);
    }

    @PutMapping("/updateCourse/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course){
        Course course1 = this.repositery.findById(id).get();
        course1.setName(course.getName());
        course1.setTitle(course.getTitle()); // This line should be course.getTitle()
        course1.setDeadline(course.getDeadline());
        course1.setScore(course.getScore());
        return this.repositery.save(course1);
    }

    @GetMapping("/myData")
    public String m1(){
        return "This is home";
    }
    
}
