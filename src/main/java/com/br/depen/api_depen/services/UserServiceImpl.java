package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.User;
import com.br.depen.api_depen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        try{
            return userRepository.save(user);
        }
        catch (Exception e){
            throw new RuntimeException("User not saved");
        }
    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("User not found with id " + id);
        }
        return userRepository.findById(id);
    }

    @Override
    public User update(Long id, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setNome(updatedUser.getNome() != null ? updatedUser.getNome() : user.getNome());
            user.setSenha(updatedUser.getSenha() != null ? updatedUser.getSenha() : user.getSenha());
            user.setRole(updatedUser.getRole() != null ? updatedUser.getRole() : user.getRole());
            user.setDocumento(updatedUser.getDocumento() != null ? updatedUser.getDocumento() : user.getDocumento());
            user.setEmail(updatedUser.getEmail() != null ? updatedUser.getEmail() : user.getEmail());
            user.setSexo(updatedUser.getSexo() != null ? updatedUser.getSexo() : user.getSexo());
            user.setUpdated_at(LocalDateTime.now());

            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }
}
