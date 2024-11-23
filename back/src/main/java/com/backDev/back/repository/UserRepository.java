package com.backDev.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backDev.back.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	boolean existsByEmail(String email);
	boolean existsByName(String name);
	Optional<User> findByEmail(String email);
}
