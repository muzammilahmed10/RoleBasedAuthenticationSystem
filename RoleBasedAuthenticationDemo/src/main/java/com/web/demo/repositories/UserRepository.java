package com.web.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);
}
