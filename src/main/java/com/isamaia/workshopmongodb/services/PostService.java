package com.isamaia.workshopmongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamaia.workshopmongodb.domain.Post;
import com.isamaia.workshopmongodb.exception.ObjectNotFoundException;
import com.isamaia.workshopmongodb.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository repository;

    public Post findById (String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

}
