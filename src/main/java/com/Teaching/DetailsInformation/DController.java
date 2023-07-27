package com.Teaching.DetailsInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DController {

    @Autowired
    private Repo repo;

    @GetMapping("/DetailPage")
    public String DetailPage(){
       return "/DetailsPage/DetailPage";
    }

    @GetMapping("/saveDetalsData")
    public String saveDetails(@RequestParam("headline") String headline, @RequestParam("info") String info){
        System.out.println("hallo world");
        ModelData d=new ModelData();
        d.setHeadLine(headline);
        d.setInfo(info);
        System.out.println(d.getHeadLine()+" "+d.getInfo());
        this.repo.save(d);
        return "redirect:/DetailPage";

    }
}
