package com.flordev.notes;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}


	@RequestMapping("/hola")
	public String hola() {
		return "Hola!";
	}
}