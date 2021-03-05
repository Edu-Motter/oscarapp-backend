package com.edumotter.oscar.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edumotter.oscar.dto.UserDTO;
import com.edumotter.oscar.dto.UserLoginDTO;
import com.edumotter.oscar.dto.UserVotesDTO;
import com.edumotter.oscar.services.UserService;
import com.github.fge.jsonpatch.JsonPatch;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> loginUser(@RequestBody UserLoginDTO dto){
		UserDTO userUpdated = service.loginUser(dto);
		if(null != userUpdated) {
			return ResponseEntity.status(200).body(userUpdated);
		}
		return ResponseEntity.status(407).body(null);
	}
	
	@PutMapping(value = "/voted")
	public ResponseEntity<UserDTO> setVotes(@RequestBody UserVotesDTO dto){
		UserDTO userUpdated = service.setVotes(dto);
		return ResponseEntity.ok().body(userUpdated);
	}
}
