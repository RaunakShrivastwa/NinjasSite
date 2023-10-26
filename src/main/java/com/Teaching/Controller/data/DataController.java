package com.Teaching.Controller.data;

import com.Teaching.Chapter.Chapter;
import com.Teaching.Chapter.ChapterRepositery;
import com.Teaching.Chapter.ChapterService;
import com.Teaching.CheakVideo.Cheak;
import com.Teaching.CheakVideo.cheakRepo;
import com.Teaching.Student.Student;
import com.Teaching.Student.StudentRepositery;
import com.Teaching.SubTopics.SubRepositery;
import com.Teaching.SubTopics.SubTopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class DataController {

    // for thr
    @Autowired
    private ChapterRepositery repositery;

    @Autowired
    private ChapterService service;

    @Autowired
    private SubRepositery sub;

    @Autowired
    private cheakRepo cheak;

    @Autowired
    private StudentRepositery studentRepo;

    @GetMapping("/lec/{id}")
    public String lec1(@PathVariable long id, Model model) {

        Chapter link = this.service.singleData(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = studentRepo.findByEmail(email);
        List<SubTopic> userList = this.sub.findByContentType(link.getContentType());
        SubTopic topic = this.sub.findById(1l).get();
        model.addAttribute("topic", topic);
        model.addAttribute("userList", userList);
        model.addAttribute("link", link);
        Cheak cheak1 = cheak.findByVideoIdAndStudentId("" + topic.getId(), student.getId());
        if (cheak1 == null) {
            cheak1 = new Cheak();
            cheak1.setFlag("false");
        }
        System.out.println("cheak list data " + cheak1);
        model.addAttribute("cheak1", cheak1);
        String flagnull = "true";
        model.addAttribute("flagnull", flagnull);
        return "lec1";
    }

    @GetMapping("/dash/{id}")
    public String dashVideo(@PathVariable long id, Model model) {

        SubTopic topic = this.sub.findById(id).get();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = studentRepo.findByEmail(email);
        List<SubTopic> userList = this.sub.findByContentType(topic.getContentType());
        Chapter link = this.repositery.findByContentType(topic.getContentType());
        model.addAttribute("topic", topic);
        model.addAttribute("userList", userList);
        model.addAttribute("link", link);
        Cheak cheak1 = cheak.findByVideoIdAndStudentId("" + topic.getId(), student.getId());
        if (cheak1 == null) {
            cheak1 = new Cheak();
            cheak1.setFlag("false");
        }
        System.out.println("cheak list data " + cheak1);
        model.addAttribute("cheak1", cheak1);
        String flagnull = "true";
        model.addAttribute("flagnull", flagnull);

        return "lec1";

    }

    @GetMapping("/Decr/{id}")
    public String lec1Decr(@PathVariable long id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = studentRepo.findByEmail(email);
        System.out.println(id);
        if (id != 1) {
            SubTopic topic = this.sub.findById(id - 1).get();

            List<SubTopic> userList = this.sub.findByContentType(topic.getContentType());
            Chapter link = this.repositery.findByContentType(topic.getContentType());
            model.addAttribute("topic", topic);
            model.addAttribute("userList", userList);
            model.addAttribute("link", link);

            Cheak cheak1 = cheak.findByVideoIdAndStudentId("" + topic.getId(), student.getId());
            if (cheak1 == null) {
                cheak1 = new Cheak();
                cheak1.setFlag("false");
            }
            System.out.println("cheak list data " + cheak1);
            model.addAttribute("cheak1", cheak1);
            String flagnull = "true";
            model.addAttribute("flagnull", flagnull);
            return "lec1";
        } else {
            SubTopic topic = this.sub.findById(id).get();

            List<SubTopic> userList = this.sub.findByContentType(topic.getContentType());
            Chapter link = this.repositery.findByContentType(topic.getContentType());
            model.addAttribute("topic", topic);
            model.addAttribute("userList", userList);
            model.addAttribute("link", link);
            model.addAttribute("link", link);
            Cheak cheak1 = cheak.findByVideoIdAndStudentId("" + topic.getId(), student.getId());
            if (cheak1 == null) {
                cheak1 = new Cheak();
                cheak1.setFlag("false");
            }
            System.out.println("cheak list data " + cheak1);
            model.addAttribute("cheak1", cheak1);
            String flagnull = "true";
            model.addAttribute("flagnull", flagnull);
            return "lec1";
        }

    }

    @GetMapping("/Incr/{id}")
    public String lec1Incr(@PathVariable long id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Student student = studentRepo.findByEmail(email);
        SubTopic topic;
        topic = this.sub.findById(id).get();
        List<SubTopic> userList = this.sub.findByContentType(topic.getContentType());
        if (id != userList.size()) {
            id = id + 1;
            topic = this.sub.findById(id).get();
        }

        Chapter link = this.repositery.findByContentType(topic.getContentType());
        model.addAttribute("topic", topic);
        model.addAttribute("userList", userList);
        model.addAttribute("link", link);
        Cheak cheak1 = cheak.findByVideoIdAndStudentId("" + topic.getId(), student.getId());
        if (cheak1 == null) {
            cheak1 = new Cheak();
            cheak1.setFlag("false");
        }
        System.out.println("cheak list data " + cheak1);
        model.addAttribute("cheak1", cheak1);
        String flagnull = "true";
        model.addAttribute("flagnull", flagnull);

        return "lec1";
    }
}
