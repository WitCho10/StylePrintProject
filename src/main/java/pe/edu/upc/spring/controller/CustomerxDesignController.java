package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Customer;
import pe.edu.upc.spring.model.CustomerxDesign;
import pe.edu.upc.spring.model.Design;
import pe.edu.upc.spring.service.ICustomerService;
import pe.edu.upc.spring.service.ICustomerxDesignService;
import pe.edu.upc.spring.service.IDesignService;

@Controller
@RequestMapping("/customerxdesign")
public class CustomerxDesignController {
	
	@Autowired
	private ICustomerxDesignService cdService;
	
	@Autowired
	private ICustomerService cuService;	
	
	@Autowired
	private IDesignService deService;	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaClientexDiseno",cdService.listar());
		return "listCustomerxDesign";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("customerxdesign", new CustomerxDesign());
		model.addAttribute("customer", new Customer());
		model.addAttribute("design", new Design());
		
		model.addAttribute("listaClientes", cuService.listar());
		model.addAttribute("listaDisenos", deService.listar());
		
		return "customerxdesign";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute CustomerxDesign objCustomerxDesign, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors()) {
			model.addAttribute("listaClientes", cuService.listar());
		    model.addAttribute("listaDisenos", deService.listar());
			return "customerxdesign";
		}
		else {
			boolean flag = cdService.Registrar(objCustomerxDesign);
			if(flag)
				return "redirect:/customerxdesign/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/customerxdesign/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<CustomerxDesign> objCustomerxDesign = cdService.listarId(id);
		if(objCustomerxDesign == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/customerxdesign/listar";
		}
		else {
			model.addAttribute("listaClientes", cuService.listar());
			model.addAttribute("listaDisenos", deService.listar());
			if(objCustomerxDesign.isPresent()) {
				objCustomerxDesign.ifPresent(o -> model.addAttribute("customerxdesign", o));
			}

			return "customerxdesign";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cdService.eliminar(id);
				model.put("listaClientesxDisenos", cdService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaClientesxDisenos", cdService.listar());
		}
		return "listCustomerxDesign";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaClientesxDisenos", cdService.listar());
		return "listCustomerxDesign";
	}
}
