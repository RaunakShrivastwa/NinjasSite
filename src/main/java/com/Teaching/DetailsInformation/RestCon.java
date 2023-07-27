package com.Teaching.DetailsInformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCon {
    
    @Autowired
    public Repo repo;

    @GetMapping("/dataAll")
    public List<ModelData> AllDetails(){
        return repo.findAll();
    }

    @GetMapping("/dataShubham")
    public String getData(){
        return "hallo world";
    }
}
