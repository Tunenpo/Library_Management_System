package com.example.MiniLibrary.service;

import com.example.MiniLibrary.model.User;
import com.example.MiniLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@EnableCaching
@Service
public class UserService {//model -> repository -> service -> controller

    public UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Cacheable(value = "getAllUsers")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @CacheEvict(value = "getAllUsers",allEntries = true)
    public User addUser (User user){
        return userRepository.save(user);
    }
    @CacheEvict(value = "getAllUsers",allEntries = true)
    public User deleteUser (Long userId){
         userRepository.deleteById(userId);
         return null;
    }
    @CacheEvict(value = "getAllUsers",allEntries = true)
    public User updateUser(User user){
        return  userRepository.save(user);
    }
    public List<User> getAll (){
        return userRepository.findAll();
    }
    public User findUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
    private User findUserByFullName(String fullName) {
        List<User> userList = userRepository.findByFullName(fullName);
        return userList.isEmpty() ? null : userList.get(0);
    }

    private User findUserByEmail(String email) {
        List<User> userList = userRepository.findByEmail(email);
        return userList.isEmpty() ? null : userList.get(0);
    }

    private  class CacheConfig{
        @Bean
        public CacheManager cacheManager(){
            return new ConcurrentMapCacheManager("getAllUsers");
        }

    }

}
