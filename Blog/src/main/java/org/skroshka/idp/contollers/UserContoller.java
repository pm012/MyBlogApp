package org.skroshka.idp.contollers;

import java.util.Optional;

import org.skroshka.idp.entities.Pager;
import org.skroshka.idp.entities.User;
import org.skroshka.idp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserContoller {
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10, 15 };
	@Autowired
	private UserRepository userRepo;

	/*
	 * @GetMapping("/") public String showPage(Model
	 * model, @RequestParam(defaultValue = "0") int page) {
	 * model.addAttribute("data", userRepo.findAll(PageRequest.of(page, 4)));
	 * model.addAttribute("currentPage", page); // currentPage = page we clicked.
	 * This variable is used on the UI to highlight // current page return "index";
	 * }
	 */

	@GetMapping("/")
	public Model homepage(Model modelAndView, @RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {

		// ModelAndView modelAndView = new ModelAndView("index");
		//
		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		// print repo
		System.out.println("here is client repo " + userRepo.findAll());
		Page<User> userlist = userRepo.findAll(PageRequest.of(evalPage, evalPageSize));
		System.out.println("client list get total pages" + userlist.getTotalPages() + "client list get number "
				+ userlist.getNumber());
		Pager pager = new Pager(userlist.getTotalPages(), userlist.getNumber(), BUTTONS_TO_SHOW);
		// add clientmodel
		// modelAndView. addObject("clientlist", userlist);
		modelAndView.addAttribute("data", userlist);
		// evaluate page size
		// modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addAttribute("selectedPageSize", evalPageSize);
		// add page sizes
		// modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addAttribute("selectedPageSize", evalPageSize);
		// add pager
		// modelAndView.addObject("pager", pager);
		modelAndView.addAttribute("pager", pager);
		// current page
		modelAndView.addAttribute("currentPage", page);
		return modelAndView;

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

	@GetMapping("/findOne")
	@ResponseBody
	public Optional<User> findOne(Integer id) {
		return userRepo.findById(id);

	}
}
