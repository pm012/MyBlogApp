package org.skroshka.idp.contollers;

import java.util.Optional;

import org.skroshka.idp.entities.User;
import org.skroshka.idp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserContoller {
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {
		model.addAttribute("data", userRepo.findAll(PageRequest.of(page, 4)));
		return "index";
	}

	@PostMapping("/save")
	public String save(User u) {
		userRepo.save(u);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String deleteUser(Integer id) {
		userRepo.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/delete")
	@ResponseBody
	public Optional<User> findOne(Integer id) {

		return userRepo.findById(id);
	}
}
