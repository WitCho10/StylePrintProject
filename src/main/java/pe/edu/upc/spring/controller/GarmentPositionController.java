package pe.edu.upc.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.spring.model.GarmentPosition;
import pe.edu.upc.spring.service.IGarmentPositionService;

@Controller
@RequestMapping("GarmentPosition")
public class GarmentPositionController {

	@Autowired
	private IGarmentPositionService cService;
	
	@RequestMapping("/bienevido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaGarmentPosition",cService.Listar());
		return "listgarmentPosition";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute GarmentPosition objGarmentPosition, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "GarmentPosition";
		else {
			boolean flag = cService.Registar(objGarmentPosition);
			if(flag)
				return "redirect:/GarmentPosition/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/GarmentPosition/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/Eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cService.Eliminar(id);
				model.put("GarmentPosition", cService.Listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("lista", cService.Listar());
		}
		return "listgarmentPosition";
	}
	
	@RequestMapping("/listar")
	public String Listar(Map<String, Object> model) {
		model.put("listaGarmentPosition", cService.Listar());
		return "listgarmentPosition";
	}
}
