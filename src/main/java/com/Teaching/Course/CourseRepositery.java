package com.Teaching.Course;


import com.Teaching.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositery extends JpaRepository<Course,Long> {
    
}
