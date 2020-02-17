package com.flordev.notes.Controller;

import com.flordev.notes.Model.Note;
import com.flordev.notes.Model.NoteRepository;
import com.flordev.notes.Model.User;
import com.flordev.notes.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.w3c.dom.Node;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
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
		Collections.reverse(notes);
		model.addAttribute("notes",notes);
		return "index";
	}

	@RequestMapping("/deleteall")
	public RedirectView deleteAll() {
		noteRepository.deleteAll();
		userRepository.deleteAll();
		return new RedirectView("/");
	}


	@PostMapping("/note/create")
	public RedirectView noteCreate(HttpServletRequest request) {
		String content= request.getParameter("content");
		String title= request.getParameter("title");
		String userName= request.getParameter("user");
		Date today= new Date();
		ArrayList<User> users  =  new ArrayList<User>();

		userRepository.findAll().forEach(users::add);
		Optional<User> userOptional= users.stream().filter(u -> u.getName().equals(userName)).findFirst();
		User user= userOptional.orElseGet(() -> new User(userName));
		userRepository.save(user);

		Note note= new Note(title,content, today,user);
		noteRepository.save(note);
		return new RedirectView("/");

		//	ArrayList<User> usuarios  =  new ArrayList<User>();

		//userRepository.findAll().forEach(usuarios::add);
		//	return usuarios.stream().map(u -> u.getName()).collect(Collectors.joining("\n"));
	}

}