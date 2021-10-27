package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pe.edu.upc.spring.service.ISupplierService;


@Controller
@RequestMapping("Supplier")
public class SupplierController {
	
	@Autowired
	private ISupplierService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaSupplier",cService.Listar());
		return "listSupplier";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("supplier", new Supplier());
		return "supplier";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Supplier objSupplier, BindingResultUtils binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "supplier";
		else {
			boolean flag = cService.Registrar(objSupplier);
			if(flag)
				return "redirect:/supplier/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/supplier/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Supplier> objSupplier = cService.ListId(idSupplier);
		if(objSupplier == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/customer/listar";
		}
		else {
			model.addAttribute("customer", objSupplier);
			return "customer";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cService.Eliminar(id);
				model.put("listaSuppliers", cService.Listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("ListaSuppliers", cService.Listar());
		}
		return "listSupplier";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("ListaSuppliers", cService.Listar());
		return "listSupplier";
		
	}
}
