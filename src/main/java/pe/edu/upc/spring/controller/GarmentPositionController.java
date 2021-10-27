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

import pe.edu.upc.spring.model.GarmentPosition;
import pe.edu.upc.spring.service.IGarmentPositionService;

@Controller
@RequestMapping("/garmentposition")
public class GarmentPositionController {

	@Autowired
	private IGarmentPositionService gpService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaPosicionPrendas",gpService.listar());
		return "listGarmentPosition";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("garmentposition", new GarmentPosition());
		return "garmentposition";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute GarmentPosition objGarmentPosition, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "garmentposition";
		else {
			boolean flag = gpService.Registrar(objGarmentPosition);
			if(flag)
				return "redirect:/garmentposition/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/garmentposition/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<GarmentPosition> objGarmentPosition = gpService.listarId(id);
		if(objGarmentPosition == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/garmentposition/listar";
		}
		else {
			model.addAttribute("garmentposition", objGarmentPosition);
			return "garmentposition";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				gpService.eliminar(id);
				model.put("listaPosicionPrendas", gpService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaPosicionPrendas", gpService.listar());
		}
		return "listGarmentPosition";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPosicionPrendas", gpService.listar());
		return "listGarmentPosition";
	}
}
