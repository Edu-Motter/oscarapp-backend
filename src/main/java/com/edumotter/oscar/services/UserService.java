package com.edumotter.oscar.services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edumotter.oscar.dto.UserDTO;
import com.edumotter.oscar.dto.UserLoginDTO;
import com.edumotter.oscar.dto.UserVoteDTO;
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
	public List<UserDTO> findAll() {
		List<User> list = repository.findAllByOrderByIdAsc();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public UserDTO loginUser(UserLoginDTO dto) {
		User user = repository.findByLogin(dto.getLogin());
		try {
			if (null != user) {
				if (user.getPassword().equals(dto.getPassword())) {
					user.setToken(getRandomNumber());
					user = repository.save(user);
					UserDTO userUpdated = new UserDTO(user);
					userUpdated.setPassword(null);
					return userUpdated;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	public UserDTO setVote(UserVoteDTO dto) {
		try {
			User user = repository.findById(dto.getIdUser()).get();
			if (user.getToken() == dto.getToken()) {
				Film film = filmRepository.findById(dto.getIdFilm()).get();
				Director director = directorRepository.findById(dto.getIdDirector()).get();
				user.setFilm(film);
				user.setDirector(director);
				user = repository.save(user);
				return new UserDTO(user);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(100) + 1;
	}
}
