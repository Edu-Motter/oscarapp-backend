package com.edumotter.oscar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edumotter.oscar.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findAllByOrderByIdAsc();

	List<User> findAllByOrderByLoginAsc();
	
	User findByLogin(String login);
	
}
