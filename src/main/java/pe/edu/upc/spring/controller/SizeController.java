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

import pe.edu.upc.spring.model.Size;
import pe.edu.upc.spring.service.ISizeService;

@Controller
@RequestMapping("/size")
public class SizeController {

	@Autowired
	private ISizeService sService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaTallas",sService.listar());
		return "listSize";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("size", new Size());
		return "size";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Size objSize, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "size";
		else {
			boolean flag = sService.Registrar(objSize);
			if(flag)
				return "redirect:/size/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/size/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Size> objSize = sService.listarId(id);
		if(objSize == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/size/listar";
		}
		else {
			model.addAttribute("size", objSize);
			return "size";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				sService.eliminar(id);
				model.put("listaTallas", sService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaTallas", sService.listar());
		}
		return "listSize";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTallas", sService.listar());
		return "listSize";
	}
}
