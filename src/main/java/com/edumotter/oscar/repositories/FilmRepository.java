package com.edumotter.oscar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edumotter.oscar.entities.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

	List<Film> findAllByOrderByIdAsc();
	
	List<Film> findAllByOrderByNameAsc();
	
}
