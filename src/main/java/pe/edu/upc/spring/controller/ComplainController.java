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

import pe.edu.upc.spring.model.Complain;
import pe.edu.upc.spring.service.IComplainService;

@Controller
@RequestMapping("/complain")
public class ComplainController {
	
	@Autowired
	private IComplainService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "Quejas";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaQuejas",cService.listar());
		return "listComplain";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("Queja", new Complain());
		return "Quejas";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Complain objComplain, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "Quejas";
		else {
			boolean flag = cService.Registrar(objComplain);
			if(flag)
				return "redirect:/Quejas/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/Quejas/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Complain> objComplain = cService.listarId(id);
		if(objComplain == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/complain/listar";
		}
		else {
			model.addAttribute("complain", objComplain);
			return "complain";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cService.eliminar(id);
				model.put("listaQuejas", cService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaQuejas", cService.listar());
		}
		return "listComplain";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaQuejas", cService.listar());
		return "listComplain";
	}
}
