package com.edumotter.oscar.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edumotter.oscar.dto.UserDTO;
import com.edumotter.oscar.dto.UserLoginDTO;
import com.edumotter.oscar.dto.UserVotesDTO;
import com.edumotter.oscar.entities.Director;
import com.edumotter.oscar.entities.Film;
import com.edumotter.oscar.entities.User;
import com.edumotter.oscar.repositories.DirectorRepository;
import com.edumotter.oscar.repositories.FilmRepository;
import com.edumotter.oscar.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private DirectorRepository directorRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> list = repository.findAllByOrderByIdAsc();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public UserDTO loginUser(UserLoginDTO dto) { 
		//Get users 
		User user = repository.findByLogin(dto.getLogin());
		//Se n for null, verifica credenciais:
		if (null != user) {
				//Dps descriptografar a senha:
				if(user.getPassword().equals(dto.getPassword())) {
					//Login correto:
					long intId = user.getId();
					int token = (100 - (int)intId); 
					user.setToken(78);
					user = repository.save(user);
					UserDTO userUpdated = new UserDTO(user);
					userUpdated.setPassword(null);
					return userUpdated;
				}				
		}
		//Login incorreto:
		return null;
	}
	
	@Transactional
	public UserDTO setVotes(UserVotesDTO dto) {
		User user = repository.findById(dto.getIdUser()).get();
		//Pega o que esta associado ao usuario?
		Film f = filmRepository.findById(dto.getIdFilm()).get();
		Director d = directorRepository.findById(dto.getIdDirector()).get();
		user.setDirector(d);
		user.setFilm(f);
		user = repository.save(user);
		return new UserDTO(user);
	}
}