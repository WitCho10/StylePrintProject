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
import pe.edu.upc.spring.model.Sale;
import pe.edu.upc.spring.model.Status;
import pe.edu.upc.spring.service.IStatusService;
import pe.edu.upc.spring.service.ICustomerService;
import pe.edu.upc.spring.service.ISaleService;

@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	private ISaleService sService;
	
	@Autowired
	private IStatusService stService;
	
	@Autowired
	private ICustomerService cuService;	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaVentas",sService.listar());
		return "listSale";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("sale", new Sale());
		model.addAttribute("customer", new Customer());
		model.addAttribute("status", new Status());
		
		model.addAttribute("listaClientes", cuService.listar());
		model.addAttribute("listaEstados", stService.listar());	
		return "sale";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Sale objSale, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors()) {
			model.addAttribute("listaClientes", cuService.listar());
			model.addAttribute("listaEstados", stService.listar());	
		
			return "sale";
		}
		else {
			boolean flag = sService.Registrar(objSale);
			if(flag)
				return "redirect:/sale/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/sale/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Sale> objSale = sService.listarId(id);
		if(objSale == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/sale/listar";
		}
		else {
			model.addAttribute("listaClientes", cuService.listar());
			model.addAttribute("listaEstados", stService.listar());	
			if (objSale.isPresent())
				objSale.ifPresent(o -> model.addAttribute("sale", o));
			
			return "sale";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				sService.eliminar(id);
				model.put("listaVentas", sService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaVentas", sService.listar());
		}
		return "listSale";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaVentas", sService.listar());
		return "listSale";
	}
}
