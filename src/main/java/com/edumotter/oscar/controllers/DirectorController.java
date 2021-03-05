package com.edumotter.oscar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edumotter.oscar.dto.DirectorDTO;
import com.edumotter.oscar.services.DirectorService;

@RestController
@RequestMapping(value = "/directors")
public class DirectorController {
	
	@Autowired
	private DirectorService service;
	
	@GetMapping
	public ResponseEntity<List<DirectorDTO>> findAll(){
		List<DirectorDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DirectorDTO> findById(@PathVariable Long id){
		DirectorDTO d = service.findById(id);
		return ResponseEntity.ok().body(d);
	}
}
