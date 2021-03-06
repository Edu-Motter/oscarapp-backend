package com.edumotter.oscar.dto;

import java.io.Serializable;

import com.edumotter.oscar.entities.Director;
import com.edumotter.oscar.entities.Film;
import com.edumotter.oscar.entities.User;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String login;
	private String password;
	private int token;
	private Director director;
	private Film film;

	public UserDTO() {	
	}

	public UserDTO(Long id, String login, String password, int token, Director director, Film film) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.token = token;
		this.director = director;
		this.film = film;
	}

	public UserDTO(User entity) {
		id = entity.getId();
		login = entity.getLogin();
		password = entity.getPassword();
		token = entity.getToken();
		director = entity.getDirector() == null ? null : entity.getDirector();
		film = entity.getFilm() == null ? null : entity.getFilm();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
}
