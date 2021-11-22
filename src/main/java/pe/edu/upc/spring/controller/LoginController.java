package pe.edu.upc.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.upc.spring.model.Customer;
import pe.edu.upc.spring.service.ICustomerService;


@Controller
public class LoginController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("customer", new Customer());
		return "login";
	}
	
	@GetMapping("/registro")
	public String registroForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "registro";
	}
	@PostMapping("/registro")
	public String registro(@Validated @ModelAttribute Customer customer,BindingResult result, Model model) {
	if(result.hasErrors()) {
		return "redirect:/registro";
	}	
	else {
		model.addAttribute("customer", customerService.Registrar(customer));
		
	}
	return "redirect:/login";
	}
}


//@GetMapping(value={"/login","/"})
	//public String login(@RequestParam(value = "error", required = false) String error,
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
//	
//	@GetMapping("/")
//	public String irLogin() {
//		return "redirect://login";
//	}
//	
//}
