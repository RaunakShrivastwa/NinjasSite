
        package com.Teaching.Controller.CurrentChapterContents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class payController {

    @GetMapping("/payjava")
    public String payJava(){
        return "payJava";
    }
}
