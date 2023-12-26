package com.isamaia.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.isamaia.workshopmongodb.domain.User;
import com.isamaia.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{


    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

       
        //limpa a coleçao no mongodb
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex,bob));
    }


    
}
