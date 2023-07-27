
package com.Teaching.Chapter;


import com.Teaching.Chapter.Chapter;
import com.Teaching.Chapter.ChapterRepositery;
import com.Teaching.Chapter.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ChapterController {

    @Autowired
    private ChapterService service;

    @Autowired
    private ChapterRepositery repositery;

   @PostMapping("/chapter")
    public Chapter saveChapter(@RequestBody Chapter chapter){
        return this.service.saveChapter(chapter);
    }

    @RequestMapping(value = "/chapter", method = RequestMethod.GET)
    public List<Chapter> getAllChapter(){
        return this.service.allChapter();
    }

    @GetMapping("/course/{course}")
    public List<Chapter> allData(@PathVariable String course){
       return this.repositery.findByCourseName(course);
    }

    @DeleteMapping("/delete/{courseId}")
    public void deleteChapter(@PathVariable Long courseId){
       this.repositery.deleteById(courseId);
    }

    @GetMapping("/getChapter/{id}")
    public Chapter getChapter(@PathVariable Long id){
        return this.repositery.findById(id).get();
    }
     
    @PutMapping("/updateChapter/{id}")
    public void updateChapter(@PathVariable Long id, @RequestBody Chapter chapter){
       Chapter chapterData= this.repositery.findById(id).get();
       chapterData.setContent(chapter.getContent());
       chapterData.setCourseName(chapter.getCourseName());
       chapterData.setDeadline(chapter.getDeadline());
       chapterData.setInformation(chapter.getInformation());
       this.repositery.save(chapterData);
    }
    
}
