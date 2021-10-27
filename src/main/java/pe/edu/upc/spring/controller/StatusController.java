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

import pe.edu.upc.spring.model.Status;
import pe.edu.upc.spring.service.IStatusService;

@Controller
@RequestMapping("/status")
public class StatusController {
	
	@Autowired
	private IStatusService sService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaEstados",sService.listar());
		return "listStatus";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("status", new Status());
		return "status";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Status objStatus, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "status";
		else {
			boolean flag = sService.Registrar(objStatus);
			if(flag)
				return "redirect:/status/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/status/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Status> objStatus = sService.listarId(id);
		if(objStatus == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/status/listar";
		}
		else {
			model.addAttribute("status", objStatus);
			return "status";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				sService.eliminar(id);
				model.put("listaEstados", sService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaEstados", sService.listar());
		}
		return "listStatus";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaEstados", sService.listar());
		return "listStatus";
	}
}
