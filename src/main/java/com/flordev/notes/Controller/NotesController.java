package com.flordev.notes.Controller;

import com.flordev.notes.Model.Note;
import com.flordev.notes.Model.NoteRepository;
import com.flordev.notes.Model.User;
import com.flordev.notes.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class NotesController {
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private UserRepository userRepository;


	@RequestMapping("/")
	public String index(Model model) {
		ArrayList<Note> notes  =  new ArrayList<Note>();
		noteRepository.findAll().forEach(notes::add);
		model.addAttribute("notes",notes);
		return "index";
	}


	@RequestMapping("/note/create")
	public RedirectView noteCreate() {
		Date today= new Date();
		ArrayList<User> usuarios  =  new ArrayList<User>();

		userRepository.findAll().forEach(usuarios::add);

		Note note= new Note("nota","primera nota", today,usuarios.get(0));
		noteRepository.save(note);
		return new RedirectView("/");

		//	ArrayList<User> usuarios  =  new ArrayList<User>();

		//userRepository.findAll().forEach(usuarios::add);
		//	return usuarios.stream().map(u -> u.getName()).collect(Collectors.joining("\n"));
	}

}