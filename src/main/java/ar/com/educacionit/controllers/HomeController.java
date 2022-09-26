
package ar.com.educacionit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	//GET > http://localhost:8080/
	@GetMapping(value = "/")
	public String home(Model model) {
		
		model.addAttribute("clave","valor123");
		
		model.addAttribute("PERSONA",new Persona("juan"));
		
		//quiero ir  a la pagina home.html
		return "home";
	}
	
	@PostMapping(value="/home/post")
	public String homePost(
			@ModelAttribute("PERSONA") Persona persona
			) {
		
		System.out.println("viene del html con el valor: "+persona.getNombre());
		
		return "redirect:/cupon/list";
	}

	class Persona {
		private String nombre;

		public Persona(String nombre) {
			super();
			this.nombre = nombre;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	}
}