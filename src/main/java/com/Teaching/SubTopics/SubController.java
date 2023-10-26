package com.Teaching.SubTopics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SubController {
    
    @Autowired
    private SubRepositery repositery;

    @PostMapping("/subTopic")
    public SubTopic saveSubTopic(@RequestBody SubTopic subTopic){
        
        return this.repositery.save(subTopic);
    }

    @GetMapping("/allSub")
    public List<SubTopic> getAllTopic(){
        return this.repositery.findAll();
    }

    @GetMapping("/getOne")
    public SubTopic getOneTopic(@PathVariable long id){
        return this.repositery.findById(id).get();
    }

    @GetMapping("/tag/{str}")
    public List<SubTopic> getByTagNAme(@PathVariable String str){
        return this.repositery.findByContentType(str);
    }
}
