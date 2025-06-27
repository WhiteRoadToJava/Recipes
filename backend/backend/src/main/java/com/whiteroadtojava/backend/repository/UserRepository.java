package com.whiteroadtojava.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whiteroadtojava.backend.modul.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be defined here if needed
    User findByUsername(String username);
}