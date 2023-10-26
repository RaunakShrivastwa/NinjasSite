
        package com.Teaching.Controller.CurrentChapterContents;

import com.Teaching.Chapter.Chapter;
import com.Teaching.Course.Course;
import com.Teaching.Chapter.ChapterRepositery;
import com.Teaching.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "*")
public class ListController {

    @Autowired
    private ChapterRepositery repositery;

    @Autowired
    private CourseService courseService;

    String name;

    @GetMapping("/ListContent/{course}")
    public String list(@PathVariable String course,Model model){
        List<Chapter> userList=this.repositery.findByCourseName(course);
        userList.stream().map(course1 ->{
          name =course1.getCourseName();
            return name;
        }).collect(Collectors.toList());
        model.addAttribute("userList",userList);
        model.addAttribute("name", name);
        return "listData";
    }
}
