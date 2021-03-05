package com.edumotter.oscar.dto;

import java.io.Serializable;

import com.edumotter.oscar.entities.Director;
import com.edumotter.oscar.entities.Film;
import com.edumotter.oscar.entities.User;

public class UserVotesDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idUser;
	private Long idFilm;
	private Long idDirector;

	public UserVotesDTO() {	
	}

	public UserVotesDTO(Long idUser, Long idFilm, Long idDirector) {
		super();
		this.idUser = idUser;
		this.idFilm = idFilm;
		this.idDirector = idDirector;
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

	
}
