package com.Teaching.Chapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepositery repositery;
    @Override
    public Chapter saveChapter(Chapter chapter) {
//        chapter.setId(UUID.randomUUID().toString());
        return this.repositery.save(chapter);
    }

    @Override
    public List<Chapter> allChapter() {
        return this.repositery.findAll();
    }

    @Override
    public Chapter singleData(Long l) {
        return this.repositery.findById(l).get();
    }

}
