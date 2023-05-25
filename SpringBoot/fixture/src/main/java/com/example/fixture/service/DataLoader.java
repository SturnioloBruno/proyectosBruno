package com.example.fixture.service;

import com.example.fixture.model.AppUsuarioRoles;
import com.example.fixture.model.Appuser;
import com.example.fixture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository repository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = passwordEncoder.encode("digital");

        repository.save(new Appuser("Rodolfo","Rodolfo","@gmail.com",pass, AppUsuarioRoles.ROLE_USER));
    }
}
