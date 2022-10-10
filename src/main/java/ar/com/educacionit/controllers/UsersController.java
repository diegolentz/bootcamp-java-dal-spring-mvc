
package ar.com.educacionit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.domain.UsersCategory;
import ar.com.educacionit.services.UsersCategoryService;
import ar.com.educacionit.services.UsersService;

@Controller
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService us;
	
	@Autowired
	private UsersCategoryService ucs;
	
	@GetMapping("/all")
	public String allUser () {
		List<Users> users = this.us.buscarTodos();
		
		System.out.println(users);
		return "home";
	}
	
	/*
	@PostMapping
	public String newUser(
			@Valid NewUserViewDTO newUser) {
			
		String passwordhashe = BCrypt.hashpw(newUser.getPassword(), "sarasa");
		
		User u = new User(newuser.getUsername());
		//u.setTodos()
		
		this.userService.save(u);
	}
	*/
	
	@GetMapping("/new")
	public ModelAndView newCupon() {
		
		Users entity = new Users();
		entity.setCategory(new UsersCategory());
		
		ModelAndView model = new ModelAndView("user/new");
		List<UsersCategory> categories = ucs.buscarTodos();
		
		model.addObject("CATEGORIES", categories);
		model.addObject("USER", entity);
		
		return model;
	}
	
	@PostMapping("/new")
	public String save(
			@Validated
			@ModelAttribute(name = "USER") Users user,
			BindingResult resul,
			Model model
			) {

		if(resul.hasErrors()) {
			model.addAttribute("message", "Vuelva a ingresar los datos del usuario");
			List<UsersCategory> categories = ucs.buscarTodos();
			
			model.addAttribute("CATEGORIES", categories);
			return "user/new";	
		}
		
		this.us.crear(user);
		model.addAttribute("message", "Usuario creado exitosamente");
		return "home";
	}
	
	
}