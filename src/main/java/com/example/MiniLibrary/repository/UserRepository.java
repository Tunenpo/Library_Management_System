package com.example.MiniLibrary.repository;

import com.example.MiniLibrary.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAll();

    User findById(long id);

    List<User> findByEmail(String email);
    List<User> findByFullName(String fullName);

    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);

}
