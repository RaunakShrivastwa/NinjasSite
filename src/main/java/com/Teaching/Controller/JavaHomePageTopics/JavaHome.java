package com.Teaching.Controller.JavaHomePageTopics;

import com.Teaching.Course.Course;
import com.Teaching.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class JavaHome {

    @Autowired
    CourseService courseService;
    @GetMapping("/javaContent1")
    public String CourseContent(Model model){
        List<Course> courses=this.courseService.allCourse();
        model.addAttribute("course", courses);
        return "Course";
    }
}
