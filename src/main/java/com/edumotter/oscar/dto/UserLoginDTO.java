package com.edumotter.oscar.dto;

import java.io.Serializable;

import com.edumotter.oscar.entities.User;

public class UserLoginDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;

	public UserLoginDTO() {	
	}

	public UserLoginDTO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public UserLoginDTO(User entity) {
		login = entity.getLogin();
		password = entity.getPassword();
	}

	public String getName() {
		return login;
	}

	public void setName(String name) {
		this.login = name;
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
}
