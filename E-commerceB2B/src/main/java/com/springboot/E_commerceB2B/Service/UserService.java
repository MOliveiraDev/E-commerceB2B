package com.springboot.E_commerceB2B.Service;

import com.springboot.E_commerceB2B.Entities.User;
import com.springboot.E_commerceB2B.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        public User registerUser(User user) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

        public User saveUser(User user) {
            return userRepository.save(user);
        }

        public User getUserById(UUID id) {
            return userRepository.findById(id).orElse(null);
        }

        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        public void deleteUser(UUID id) {
            userRepository.deleteById(id);
        }
}
