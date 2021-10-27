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

import pe.edu.upc.spring.model.GarmentType;
import pe.edu.upc.spring.service.IGarmentTypeService;

@Controller
@RequestMapping("/garmenttype")
public class GarmentTypeController {

	@Autowired
	private IGarmentTypeService gpService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaTipoPrendas",gpService.listar());
		return "listGarmentType";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("garmenttype", new GarmentType());
		return "garmenttype";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute GarmentType objGarmentType, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "garmenttype";
		else {
			boolean flag = gpService.Registrar(objGarmentType);
			if(flag)
				return "redirect:/garmenttype/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/garmenttype/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<GarmentType> objGarmentType = gpService.listarId(id);
		if(objGarmentType == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/garmenttype/listar";
		}
		else {
			model.addAttribute("garmenttype", objGarmentType);
			return "garmenttype";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				gpService.eliminar(id);
				model.put("listaTipoPrendas", gpService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaTipoPrendas", gpService.listar());
		}
		return "listGarmentType";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTipoPrendas", gpService.listar());
		return "listGarmentType";
	}
}
