package com.edumotter.oscar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edumotter.oscar.entities.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{

	List<Director> findAllByOrderByIdAsc();

	List<Director> findAllByOrderByNameAsc();
}
