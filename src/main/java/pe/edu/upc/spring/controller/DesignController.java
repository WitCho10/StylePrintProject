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


import pe.edu.upc.spring.model.Design;
import pe.edu.upc.spring.model.Designer;
import pe.edu.upc.spring.service.IDesignService;
import pe.edu.upc.spring.service.IDesignerService;

@Controller
@RequestMapping("/design")
public class DesignController {
	
	@Autowired
	private IDesignService dService;
	
	@Autowired
	private IDesignerService deService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "MenuDiseñador";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaDisenos",dService.listar());
		return "listDesign";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("design", new Design());
		model.addAttribute("designer", new Designer());
		
		model.addAttribute("listaDisenadores", deService.listar());
		
		return "Estampado";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Design objDesign, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors()) {
			model.addAttribute("listaDisenadores", deService.listar());
			return "design";
		}
		else {
			boolean flag = dService.Registrar(objDesign);
			if(flag)
				return "redirect:/design/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/design/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Design> objDesign = dService.listarId(id);
		if(objDesign == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/design/listar";
		}
		else {
			model.addAttribute("listaDisenadores", deService.listar());
			
			if(objDesign.isPresent()) {
				objDesign.ifPresent(o -> model.addAttribute("design", o));
			}
			return "design";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				dService.eliminar(id);
				model.put("listaDisenos", dService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaDisenos", dService.listar());
		}
		return "listDesign";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDisenos", dService.listar());
		return "listDesign";
		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("design", new Design());
		return "buscar";
	}	
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Design design)
			throws ParseException
	{
		List<Design> listaDisenos;
		design.setNameDesign(design.getNameDesign());
		listaDisenos = dService.buscarNombre(design.getNameDesign());
		
		
		if (listaDisenos.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaDisenos", listaDisenos);		
		return "buscar";
	}		
	
	
}
