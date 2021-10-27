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


import pe.edu.upc.spring.model.Designer;
import pe.edu.upc.spring.service.IDesignerService;

@Controller
@RequestMapping("/designer")
public class DesignerController {
	
	@Autowired
	private IDesignerService dService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaDisenadores",dService.listar());
		return "listDesigner";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("designer", new Designer());
		return "designer";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Designer objDesigner, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "designer";
		else {
			boolean flag = dService.Registrar(objDesigner);
			if(flag)
				return "redirect:/designer/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/designer/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Designer> objDesigner = dService.listarId(id);
		if(objDesigner == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/designer/listar";
		}
		else {
			model.addAttribute("designer", objDesigner);
			return "designer";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				dService.eliminar(id);
				model.put("listaDisenadores", dService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaDisenadores", dService.listar());
		}
		return "listDesigner";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDisenadores", dService.listar());
		return "listDesigner";
		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("designer", new Designer());
		return "buscar";
	}	
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Designer designer)
			throws ParseException
	{
		List<Designer> listaDisenadores;
		designer.setNameDesigner(designer.getNameDesigner());
		listaDisenadores = dService.buscarNombre(designer.getNameDesigner());
		
		
		if (listaDisenadores.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaDisenadores", listaDisenadores);		
		return "buscar";
	}		
	
	
}
