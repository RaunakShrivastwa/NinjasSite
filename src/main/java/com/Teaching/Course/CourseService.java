package com.Teaching.Course;

import com.Teaching.Course.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);

    List<Course> allCourse();

    Course getSingle(Long id);
}
