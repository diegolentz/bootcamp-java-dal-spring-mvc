
package ar.com.educacionit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService us;
	
	@GetMapping("/all")
	public String allUser () {
		List<Users> users = this.us.buscarTodos();
		
		System.out.println(users);
		return "home";
	}
}