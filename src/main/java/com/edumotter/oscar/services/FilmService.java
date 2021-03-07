package com.edumotter.oscar.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edumotter.oscar.dto.FilmDTO;
import com.edumotter.oscar.entities.Film;
import com.edumotter.oscar.repositories.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository repository;
	
	@Transactional(readOnly = true)
	public List<FilmDTO> findAll(){
		List<Film> list = repository.findAllByOrderByIdAsc();
		return list.stream().map(x -> new FilmDTO(x)).collect(Collectors.toList());
	}
	
	public Film findById(Long id) {
        Film film = repository.findById(id).orElse(null);
        return film;

    }

}
