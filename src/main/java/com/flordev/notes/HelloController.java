package com.flordev.notes;

import com.flordev.notes.Model.NoteRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}


	@RequestMapping("/hola")
	public String hola(NoteRepository n) {
		return "Hola!";
	}
}