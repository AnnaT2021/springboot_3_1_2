package com.test_springboot.springboot_3_1_2.controller;

import com.test_springboot.springboot_3_1_2.model.User;
import com.test_springboot.springboot_3_1_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {
	private UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String index(Model model){
		model.addAttribute("users", userService.allUsers());
		return "/users/users";
	}

	@GetMapping(value = "/{id}")
	public String showUser(@PathVariable("id") int id, Model model){
		model.addAttribute("user", userService.getUserByID(id));
		return "users/show";
	}

	@GetMapping(value = "/add")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "users/add";
	}

	@PostMapping(value = "/add")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.add(user);

		return "redirect:/users";
	}

	@GetMapping(value = "/{id}/edit")
	public String editUser (@PathVariable("id") int id, Model model) {
		model.addAttribute("user", userService.getUserByID(id));
		return "users/edit";
	}

	@PostMapping(	value = "/{id}")
	public String update (@ModelAttribute("user") User user,
						  @PathVariable("id") int id){
		userService.update(id, user);
		return "redirect:/users";
	}

	@GetMapping(value = "/{id}/delete")
	public String deleteUser (@PathVariable("id") int id) {
		this.userService.delete(id);
		return "redirect:/users";
	}
}