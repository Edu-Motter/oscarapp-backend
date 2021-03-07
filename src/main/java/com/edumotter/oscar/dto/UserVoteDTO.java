package com.edumotter.oscar.dto;

import java.io.Serializable;

public class UserVoteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idUser;
	private Long idFilm;
	private Long idDirector;
	private Long token;

	public UserVoteDTO() {	
	}

	public UserVoteDTO(Long idUser, Long idFilm, Long idDirector, Long token) {
		super();
		this.idUser = idUser;
		this.idFilm = idFilm;
		this.idDirector = idDirector;
		this.token = token;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}

	public Long getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(Long idDirector) {
		this.idDirector = idDirector;
	}

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

}
