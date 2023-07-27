package com.Teaching.Chapter;

import com.Teaching.Chapter.Chapter;

import java.util.List;

public interface ChapterService {
    Chapter saveChapter(Chapter chapter);

    List<Chapter> allChapter();

    Chapter singleData(Long l);

}
