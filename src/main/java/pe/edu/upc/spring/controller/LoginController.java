package pe.edu.upc.spring.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping
public class LoginController {

//	@GetMapping(value={"/login","/"})
//	public String login(@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
//			RedirectAttributes flash) {
//		
//		if(principal != null) {
//			return "redirect:/customer/perfil";
//		}
//		if(error !=null) {
//			model.addAttribute("Error","Error en el login");
//		}
//		if(logout !=null) {
//			model.addAttribute("Success", "Ha cerrado sesión correctamente");
//		}
//		return "Cliente/LoginCliente";
//
//	}
//	
//	@GetMapping(value={"/login","/"})
//	public String login(@RequestParam(value="error",required=false)String error, Model model) {
//	
//		if(error!=null)
//		{
//			model.addAttribute("error","error");
//	   }
//		return "Cliente/LoginCliente";
//	}
	@GetMapping("/login")
	public String login() {
		return "Cliente/LoginCliente";
	}
	@GetMapping("/menu")
	public String menu() {
		return "Cliente/PerfilCliente";
	}
	@GetMapping("/")
	public String irLogin() {
		return "redirect://login";
	}
	
}
