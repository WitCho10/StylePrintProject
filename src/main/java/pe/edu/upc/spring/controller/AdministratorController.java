package pe.edu.upc.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Administrator;
import pe.edu.upc.spring.service.IAdministratorService;

@Controller
@RequestMapping("/Administrator")
public class AdministratorController {

	@Autowired
	private IAdministratorService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenido() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaAdministrador",cService.listar());
		return "listAdministrator";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("Administrator", new Administrator());
		return "administrator";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Administrator objAdministrator, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "administrator";
		else {
			boolean flag = cService.Registrar(objAdministrator);
			if(flag)
				return "redirect:/Administrator/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/Administrator/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cService.Eliminar(id);
				model.put("listaAdministrator", cService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaAdministrator", cService.listar());
		}
		return "listAdministrator";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaAdministrator", cService.listar());
		return "listAdministrator";
		
	}
}
	
