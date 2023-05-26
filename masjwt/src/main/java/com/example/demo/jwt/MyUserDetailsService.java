package com.example.demo.jwt;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    // Tenemos que buscar al usuario en la base de datos
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userBuscado = userRepository.findByUsername(userName);
        if (userBuscado.isPresent()) {
            return userBuscado.get();
        }else {
            throw new UsernameNotFoundException("Nombre de usuario no encontrado en la BD");
        }
    }
}
