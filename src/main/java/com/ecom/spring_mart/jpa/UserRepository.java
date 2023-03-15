package com.ecom.spring_mart.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecom.spring_mart.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {}
