package com.isamaia.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isamaia.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository <Post, String> {

    
}
