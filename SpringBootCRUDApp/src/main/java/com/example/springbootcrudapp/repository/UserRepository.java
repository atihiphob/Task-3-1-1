package com.example.springbootcrudapp.repository;

import com.example.springbootcrudapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {

}
