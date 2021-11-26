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
import pe.edu.upc.spring.model.Design;
import pe.edu.upc.spring.service.IDesignerService;
import pe.edu.upc.spring.service.IDesignService;

@Controller
@RequestMapping("/designer")
public class DesignerController {
	
	@Autowired
	private IDesignerService dService;
	@Autowired
	private IDesignService deService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida(Model model) {
		model.addAttribute("designer",new Designer());
		return "InicioDiseñador";
	}
	
	@RequestMapping("/perfil")
	public String irPaginaInicio(Model model) {
		model.addAttribute("designer", new Designer());
		return "MenuDiseñador";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaDisenadores",dService.listar());
		return "listDesigner";
	}
	
	@RequestMapping("/editarperfil")
	public String irPaginaEditar(Model model) {
		model.addAttribute("designer", new Designer());
		return "Editar";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("designer", new Design());
		model.addAttribute("design", new Design());
		model.addAttribute("listaEstampados", deService.listar());
		model.addAttribute("listaDisenadores", dService.listar());
		return "Estampado";
	}
	
	@RequestMapping("/registrarEstampado")
	public String registrar(@ModelAttribute("design") Design objDesign, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors()) {
			model.addAttribute("listaEstampados", deService.listar());
			model.addAttribute("listaDisenadores", dService.listar());
			return "Estampado";
		}
			
		else {
			boolean flag = deService.Registrar(objDesign);
			if(flag)
				return "redirect:/designer/irRegistrar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/designer/irRegistar";				
			}			
		}		
	}
	
	@RequestMapping("/modificarEstampado/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Design> objDesign = deService.listarId(id);
		if(objDesign == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/designer/listarEstampado";
		}
		else {
			model.addAttribute("design", objDesign.get());
			return "Estampado";
		}
	}
	
	@RequestMapping("/eliminarEstampado")
	public String eliminarEstampado(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				deService.eliminar(id);
				model.put("listaEstampados", deService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaEstampados", deService.listar());
		}
		return "listadiseños";
	}
	
	@RequestMapping("/listarEstampado")
	public String listarEstampado(Map<String, Object> model) {
		model.put("listaEstampados", deService.listar());
		return "listadiseños";		
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
