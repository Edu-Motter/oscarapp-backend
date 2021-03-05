package com.edumotter.oscar.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edumotter.oscar.dto.DirectorDTO;
import com.edumotter.oscar.entities.Director;
import com.edumotter.oscar.entities.Film;
import com.edumotter.oscar.repositories.DirectorRepository;

@Service
public class DirectorService {
	
	@Autowired
	private DirectorRepository repository;
	
	@Transactional(readOnly = true)
	public List<DirectorDTO> findAll(){
		List<Director> list = repository.findAllByOrderByIdAsc();
		return list.stream().map(x -> new DirectorDTO(x)).collect(Collectors.toList());
	}
	
	public DirectorDTO findById(Long id) {
		Director director = repository.findById(id).get();
        return new DirectorDTO(director);
    }

}
