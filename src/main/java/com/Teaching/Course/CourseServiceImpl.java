package com.Teaching.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepositery repositery;

    @Override
    public Course saveCourse(Course course) {
        return this.repositery.save(course);
    }

    @Override
    public List<Course> allCourse() {
       return this.repositery.findAll();
    }

    @Override
    public Course getSingle(Long id) {
       return this.repositery.findById(id).get();
    }
    
}
