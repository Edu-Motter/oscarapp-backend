package com.edumotter.oscar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edumotter.oscar.dto.FilmDTO;
import com.edumotter.oscar.services.FilmService;

@RestController
@RequestMapping(value = "/films")
public class FilmController {
	
	@Autowired
	private FilmService service;
	
	@GetMapping
	public ResponseEntity<List<FilmDTO>> findAll(){
		List<FilmDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
