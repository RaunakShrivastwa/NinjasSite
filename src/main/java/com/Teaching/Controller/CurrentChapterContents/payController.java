
        package com.Teaching.Controller.CurrentChapterContents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class payController {

    @GetMapping("/payjava")
    public String payJava(){
        return "/JavaCourseDataContent/payJava";
    }
}
