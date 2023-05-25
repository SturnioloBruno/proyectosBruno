package com.example.fixture.service;

import com.example.fixture.model.Appuser;
import com.example.fixture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Appuser> usuarioBuscado = userRepository.findByEmail(username);
        if (usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }else {
            throw new UsernameNotFoundException("Email de ususario no encontrado");
        }
    }
}
