package com.Teaching.Student;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Teaching.Student.Student;
import com.Teaching.Student.StudentService;



@Controller
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private StudentRepositery repositery;

    @PostMapping("/postData1")
    public String saveUser(@RequestParam("fName") String fName,
            @RequestParam("lName") String lName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("dob") String dob,
            @RequestParam("number") String number,
            @RequestParam("height") String height,
            @RequestParam("weight") String weight,
            @RequestParam("gender") String gender,
            @RequestParam("file") MultipartFile file) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        Student user = new Student();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid file");
        }
        try {
            user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setDob(dob);
        user.setEmail(email);
        user.setFName(fName);
        user.setGender(gender);
        user.setHeight(height);
        user.setId(UUID.randomUUID().toString());
        user.setNumber(number);
        user.setPassword(encode);
        user.setWeight(weight);
        user.setRole("ROLE_NORMAL");
        user.setLName(lName);


        // Student student = Student.builder()
        //         .id(UUID.randomUUID().toString())
        //         .dob(dob)
        //         .email(email)
        //         .fName(fName)
        //         .lName(lName)
        //         .gender(gender)
        //         .lName(lName)
        //         .password(encode)
        //         .height(height)
        //         .role("ROLE_NORMAL")
        //         .weight(weight)
        //         .number(number)
        //         .build();
        System.out.println("inside function");
        this.service.saveStudent(user);
        return "redirect:/register";
    }

  
    
}
