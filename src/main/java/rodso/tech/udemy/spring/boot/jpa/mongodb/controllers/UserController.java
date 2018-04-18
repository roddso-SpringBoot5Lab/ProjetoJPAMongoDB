package rodso.tech.udemy.spring.boot.jpa.mongodb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import rodso.tech.udemy.spring.boot.jpa.mongodb.repository.UserRepository;

@Controller
public class UserController {
	
	private UserRepository userRepository;
	
	UserController (UserRepository userRespository)
	{
		this.userRepository = userRespository;
	}
	
	@RequestMapping("/user")
	public String getUsers(Model model)
	{
		model.addAttribute("usersList",this.userRepository.findAll());
		return "user";
	}

}
