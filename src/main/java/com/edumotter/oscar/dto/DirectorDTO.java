package com.edumotter.oscar.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.edumotter.oscar.entities.Director;

public class DirectorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private List<UserDTO> users = new ArrayList<>();
	
	public DirectorDTO() {	
	}

	public DirectorDTO(Long id, String name, String genre, String photo) {
		this.id = id;
		this.name = name;
	}
	
	public DirectorDTO(Director entity) {
		id = entity.getId();
		name = entity.getName();
		//users = entity.getUsers().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserDTO> getUsers() {
		return users;
	}
	
}
