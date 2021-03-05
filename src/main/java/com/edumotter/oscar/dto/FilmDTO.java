package com.edumotter.oscar.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.edumotter.oscar.entities.Film;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class FilmDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String genre;
	private String photo;
	private List<UserDTO> users = new ArrayList<>();

	public FilmDTO() {	
	}

	public FilmDTO(Long id, String name, String genre, String photo) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.photo = photo;
	}
	
	public FilmDTO(Film entity) {
		id = entity.getId();
		name = entity.getName();
		genre = entity.getGenre();
		photo = entity.getPhoto();
		users = entity.getUsers().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<UserDTO> getUsers() {
		return users;
	}
	
}
