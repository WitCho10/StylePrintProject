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

import pe.edu.upc.spring.model.Administrator;
import pe.edu.upc.spring.model.Garment;
import pe.edu.upc.spring.model.GarmentPosition;
import pe.edu.upc.spring.model.GarmentType;
import pe.edu.upc.spring.model.Size;
import pe.edu.upc.spring.model.Supplier;
import pe.edu.upc.spring.service.IAdministratorService;
import pe.edu.upc.spring.service.IGarmentPositionService;
import pe.edu.upc.spring.service.IGarmentService;
import pe.edu.upc.spring.service.IGarmentTypeService;
import pe.edu.upc.spring.service.ISizeService;
import pe.edu.upc.spring.service.ISupplierService;

@Controller
@RequestMapping("/garment")
public class GarmentController {

	@Autowired
	private IGarmentService gService;
	
	@Autowired
	private IGarmentTypeService gtService;
	
	@Autowired
	private IGarmentPositionService gpService;
	
	@Autowired
	private ISizeService sService;
	
	@Autowired
	private ISupplierService suService;
	
	@Autowired
	private IAdministratorService aService;
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaPrendas",gService.listar());
		return "listGarment";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("garment", new Garment());
		model.addAttribute("garmenttype", new GarmentType());
		model.addAttribute("garmentposition", new GarmentPosition());
		model.addAttribute("size", new Size());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("administrator", new Administrator());
		
		model.addAttribute("listaTipoPrendas", gtService.listar());
		model.addAttribute("listaPosicionPrendas", gpService.listar());
		model.addAttribute("listaTallas", sService.listar());
		model.addAttribute("listaProveedores", suService.listar());
		model.addAttribute("listaAdministradores", aService.listar());
		
		return "garment";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Garment objGarment, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors()) {
			model.addAttribute("listaTipoPrendas", gtService.listar());
			model.addAttribute("listaPosicionPrendas", gpService.listar());
			model.addAttribute("listaTallas", sService.listar());
			model.addAttribute("listaProveedores", suService.listar());
			model.addAttribute("listaAdministradores", aService.listar());
			return "garment";
		}
		else {
			boolean flag = gService.Registrar(objGarment);
			if(flag)
				return "redirect:/garment/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/garment/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Garment> objGarment = gService.listarId(id);
		if(objGarment == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/garment/listar";
		}
		else {
			model.addAttribute("listaTipoPrendas", gtService.listar());
			model.addAttribute("listaPosicionPrendas", gpService.listar());
			model.addAttribute("listaTallas", sService.listar());
			model.addAttribute("listaProveedores", suService.listar());
			model.addAttribute("listaAdministradores", aService.listar());
			
			if (objGarment.isPresent())
				objGarment.ifPresent(o -> model.addAttribute("garment", o));
			
			return "garment";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				gService.eliminar(id);
				model.put("listaPrendas", gService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaPrendas", gService.listar());
		}
		return "listGarment";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPrendas", gService.listar());
		return "listGarment";
	}
}
