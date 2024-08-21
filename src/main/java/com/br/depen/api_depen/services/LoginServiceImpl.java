package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.Login;
import com.br.depen.api_depen.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService, UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login save(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    @Override
    public Optional<Login> findById(Long id) {
        return loginRepository.findById(id);
    }


    @Override
    public Login update(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public void deleteById (Long id) {
        loginRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) loginRepository.findByName(username);
    }
}
