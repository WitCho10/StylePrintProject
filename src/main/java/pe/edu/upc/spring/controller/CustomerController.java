package pe.edu.upc.spring.controller;

import java.util.List;
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
import pe.edu.upc.spring.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "InicioCliente";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaClientes",cService.listar());
		return "listCustomer";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("MenuCliente", new Customer());
		return "MenuCliente";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Customer objCustomer, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "CuentaCliente";
		else {
			boolean flag = cService.Registrar(objCustomer);
			if(flag)
				return "redirect:/CuentaCliente/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/CuentaCliente/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Customer> objCustomer = cService.listarId(id);
		if(objCustomer == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/customer/listar";
		}
		else {
			model.addAttribute("customer", objCustomer);
			return "customer";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cService.eliminar(id);
				model.put("listaClientes", cService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaClientes", cService.listar());
		}
		return "listCustomer";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaClientes", cService.listar());
		return "listCustomer";
		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("customer", new Customer());
		return "buscar";
	}	
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Customer customer)
			throws ParseException
	{
		List<Customer> listaClientes;
		customer.setNameCustomer(customer.getNameCustomer());
		listaClientes = cService.buscarNombre(customer.getNameCustomer());
		
		
		if (listaClientes.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaClientes", listaClientes);		
		return "buscar";
	}		
	
	
}
