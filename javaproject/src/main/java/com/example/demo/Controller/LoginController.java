package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.Domain.User;
import com.example.demo.Service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService UserService;


	@GetMapping("/login")
	public String loginView() {
		return "login";
	}

	@PostMapping("/login")
	public String login(User user, Model model) {
		User findUser = UserService.getMember(user);

		if (findUser != null && findUser.getPassword().equals(user.getPassword())) {
			model.addAttribute("user", findUser);
			return "forward:success";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/success")
	public String success() {
		return "success";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@PostMapping("/add")
	public String add(User user, Model model) {
		System.out.println(user);
		UserService.insertUser(user);
		return "login";
	}
	
	@GetMapping("/findpw")
	public String findpw() {
		return "findpw";
	}
	
	@PostMapping("/findpw")
	public String findpw(User user, Model model) {
		User findUser = UserService.getMember(user);
		
		if (findUser !=null && findUser.getId().equals(user.getId())
				&& findUser.getQuestion().equals(user.getQuestion())
				&& findUser.getAnswer().equals(user.getAnswer())) {
			return "login";
		}else return "findpw";
	}//팝업 좀 더 공부하고 값을 팝업으로 하려고 함다

	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:main";
	}

}
