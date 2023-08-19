package com.Teaching.CheakVideo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Teaching.Student.Student;
import com.Teaching.Student.StudentRepositery;

@RestController
public class cheakController {

    @Autowired
    private cheakRepo repo;

    @Autowired
    private StudentRepositery repositery;

    @PostMapping("/cheakData/{videoId}")
    public void savedata(@PathVariable String videoId){
        Cheak cheak=new Cheak();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student= repositery.findByEmail(email);
        cheak.setId(UUID.randomUUID().toString());
        cheak.setStudentId(student.getId());
        cheak.setFlag("true");
        cheak.setVideoId(videoId);
        repo.save(cheak);

       }
    
}
