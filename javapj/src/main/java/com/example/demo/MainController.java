package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.exceptions.TemplateInputException;

@Controller
@RequestMapping(path="/user")
public class MainController {
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/main")
	public String mainView() {
		return "user/main";
	}
	
	@RequestMapping("/hello")
	public String helloView() {
		return "user/hello";
	}
	
	@GetMapping("/insertUser")
	public String insertView() {
		return "user/insertUser";
	}
	
	@PostMapping("insertUser")
	public ModelAndView insert(User user, ModelAndView mav){
		if(userRepository.findById(user.getId()).isEmpty()) {
			userRepository.save(user);
			mav.addObject("data", new Message("회원 가입 성공", "/user/main"));
			mav.setViewName("user/message");
			return mav;
		}
		else {
			System.out.println("이미 있는 회원");
			mav.addObject("data", new Message("이미 있는 회원입니다", "/user/insertUser"));
			mav.setViewName("user/message");
			return mav;
		}
	}
	
	@GetMapping("/login")
	public String loginView() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public ModelAndView login(User user) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		if(userRepository.findById(user.getId()).isEmpty()) {
			mav.addObject("data", new Message("없는 회원입니다", "/user/login"));
			mav.setViewName("user/message");
			return mav;
		}
		else {
			if(user.getPassword().equals(userRepository.findById(user.getId()).get().getPassword())) {
				System.out.println("로그인 성공");
				mav.addObject("data", new Message("로그인 성공", "/user/main"));
				mav.setViewName("user/message");
				return mav;
			}
			System.out.println("비밀번호 불일치");
			mav.addObject("data", new Message("비밀번호가 일치하지 않습니다", "/user/login"));
			mav.setViewName("user/message");
			return mav;
		}
	}
	///////////////////////////////////////////11월 1일
	@RequestMapping("/getProductList")
	public String getProductList(Model model, String division) {
		System.out.println("getProductList called");
		System.out.println(division);
		Iterable<Product> plist = productRepository.findByDivision(division);
		model.addAttribute("plist", plist);
		System.out.println(plist.toString());
		
		return "user/getProductList";
	}
}
