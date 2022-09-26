
package ar.com.educacionit.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cupon")
public class CuponesController {

	/*
	 	http://localhost:8080/cupon/list 
	 */
	@GetMapping("/list")
	public String list(Model model) {
		
		Set<String> cupones = Set.of("Cupon1","Cupon2","Cupon3");
		
		//para pasar una lista a la vista debemos usar la interface Model
		
		//new Model();
		model.addAttribute("list", cupones);
		
		return "list";//resources/templates/list.html
	}
}