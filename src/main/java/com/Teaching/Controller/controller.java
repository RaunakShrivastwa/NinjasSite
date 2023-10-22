package com.Teaching.Controller;

import com.Teaching.Course.Course;
import com.Teaching.DetailsInformation.ModelData;
import com.Teaching.DetailsInformation.Repo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.Teaching.Student.StudentRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Teaching.Course.CourseService;

import com.Teaching.DetailsInformation.RestCon;
import com.Teaching.Student.Student;

@Controller
public class controller {

    @Autowired
    Repo r1;

    @Autowired
    StudentRepositery repositery;

    @Autowired
    CourseService courseService;

    @GetMapping("/data")
    public String data(){
        return "index";
    }

    @GetMapping("/site")
    public String skelton(){
        return "skletene";
    }


   @GetMapping("/home")
    public String Home(Model model){
     RestCon r=new RestCon();
       ModelData data1 = r1.findById(1l).get();
       ModelData data2 = r1.findById(2l).get();
       ModelData data3 = r1.findById(3l).get();
       model.addAttribute("data1",data1);
       model.addAttribute("data2",data2);
       model.addAttribute("data3",data3);

       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String email = authentication.getName();
       Student student = repositery.findByEmail(email);
       model.addAttribute("user",student);
       model.addAttribute("log",email);
    //    System.out.println(email);


       return "/home";
    }

    @GetMapping("/about")
    public String About(){
        return "/About/about";
    } 

    @GetMapping("/bca")
    public String Bca(){
        return "/SpecialCertificatesCourse/bca";
    }

   @GetMapping("/mca")
    public String Mca(){
        return "/SpecialCertificatesCourse/mca";
    }

    @GetMapping("/java")
    public String javaContent(Model model){
        List<Course> courses=this.courseService.allCourse();
        model.addAttribute("course", courses);
        return "/Course/java";
    }

    @GetMapping("/c")
    public String c(){
        return "/Course/c";
    }

   @GetMapping("/c++")
    public String c1(){
        return "/Course/c++";
    }

    
    @GetMapping("/dataScience")
    public String dataScience(){
        return "/Course/dataScience";
    }

    
    @GetMapping("/dsa")
    public String dsa(){
        return "/Course/dsa";
    }

    
    @GetMapping("/javaBackend")
    public String javaBackend(){
        return "/JavaCourseDataContent/JavaAllContent/javaBackend";
    }

   
    @GetMapping("/resume")
    public String resume(){
        return "resume";
    }

   @GetMapping("/web")
    public String web(){
        return "/Course/web";
    }

   @GetMapping("/loginPage")
    public String DoLogin(){
        return "/Login/login";
    }

    @GetMapping("/register")
    public String Registration(Model model){
        model.addAttribute("Student",new Student());
        return "/Registration/register";
    }

   
    @PostMapping("/postData")
    public String postData(){
        
        return "redirect:/Registration/register";
    }

    @GetMapping("/access")
    public String Denie(){
        return "/Acess/denied";
    }

    @GetMapping("/mobile")
    public String mobile(){
        return "/Mobile/mobile";
    }

    @GetMapping("/lab")
    public String lab(){
        return "/labs/lab";
    }

     @GetMapping("/AdminPage")
     void AdminPage(HttpServletResponse response) throws IOException {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String email = authentication.getName();
       Student student = repositery.findByEmail(email);
    response.sendRedirect("http://localhost:3000/"+student.getId());
  }


    @GetMapping("/pages")
    public String pageAdmin(Model model){
         RestCon r=new RestCon();
       ModelData data1 = r1.findById(1l).get();
       ModelData data2 = r1.findById(2l).get();
       ModelData data3 = r1.findById(3l).get();
       model.addAttribute("data1",data1);
       model.addAttribute("data2",data2);
       model.addAttribute("data3",data3);

       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String email = authentication.getName();
       Student student = repositery.findByEmail(email);
       model.addAttribute("user",student);
       model.addAttribute("log",email);
       return "/AdminPage/admin";
    }

    @GetMapping("/cheakPage")
    public String PageCheak(){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String email = authentication.getName();
        Student student=repositery.findByEmail(email);

       if(student.getRole().equals("ROLE_ADMIN")){
          return "redirect:/AdminPage";
       }
       else{
         return "redirect:/home";
       }

    }

    @GetMapping("/call")
    public String pageCall(){
        return "cheakPage";
    }
}
