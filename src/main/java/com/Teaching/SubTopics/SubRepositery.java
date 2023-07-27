package com.Teaching.SubTopics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRepositery extends JpaRepository<SubTopic,Long>{
    List<SubTopic> findByContentType(String contentType);
}