package com.isamaia.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isamaia.workshopmongodb.domain.User;
import com.isamaia.workshopmongodb.dto.UserDTO;
import com.isamaia.workshopmongodb.exception.ObjectNotFoundException;
import com.isamaia.workshopmongodb.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;


    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj) {
        User newobj = findById(obj.getId());
        updateData(newobj, obj);
        return repository.save(newobj);
    }

    private void updateData(User newobj, User obj) {
        newobj.setEmail(obj.getEmail());
        newobj.setName(obj.getName());
    }
 }

