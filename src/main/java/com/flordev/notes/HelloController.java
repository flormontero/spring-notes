package com.flordev.notes;

import com.flordev.notes.Model.NoteRepository;
import com.flordev.notes.Model.User;
import com.flordev.notes.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class HelloController {
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private UserRepository userRepository;


	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}


	@RequestMapping("/hola")
	public String hola(NoteRepository n) {
		return "Hola!";
	}

	@RequestMapping("/crearUsuario")
	public String crearUsuario( ) {
		User user = new User("flor");
		userRepository.save(user);
		return userRepository.findByName("flor").getName();
	}

	@RequestMapping("/crearUsuario2")
	public String crearUsuario2( ) {
		User user = new User("flor2");
		userRepository.save(user);
		return userRepository.findByName("flor2").getName();
	}

	@RequestMapping("/listaUsarios")
	public String listaUsarios( ) {
		ArrayList<User> usuarios  =  new ArrayList<User>();

		userRepository.findAll().forEach(usuarios::add);
		return usuarios.stream().map(u -> u.getName()).collect(Collectors.joining("\n"));
	}
}