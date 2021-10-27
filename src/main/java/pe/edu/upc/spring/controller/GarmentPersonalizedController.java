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

import pe.edu.upc.spring.model.Garment;
import pe.edu.upc.spring.model.GarmentPersonalized;
import pe.edu.upc.spring.model.Customer;
import pe.edu.upc.spring.service.IGarmentService;
import pe.edu.upc.spring.service.IGarmentPersonalizedService;
import pe.edu.upc.spring.service.ICustomerService;

@Controller
@RequestMapping("/garmentpersonalized")
public class GarmentPersonalizedController {

	@Autowired
	private IGarmentPersonalizedService ccService;
	
	@Autowired
	private IGarmentService coService;
	
	@Autowired
	private ICustomerService cuService;	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
		
	@RequestMapping("/")
	public String irPaginaListadoMascotas(Map<String, Object> model) {
		model.put("listaPrendaPersonalizadas", ccService.listar());
		return "listGarmentPersonalized";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("garment", new Garment());
		model.addAttribute("garmentpersonalized", new GarmentPersonalized());
		
		model.addAttribute("listaClientes", cuService.listar());
		model.addAttribute("listaPrendas", coService.listar());		
		
		return "garmentpersonalized";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute GarmentPersonalized objGarmentPersonalized, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors()) 
			{
			model.addAttribute("listaClientes", cuService.listar());
			model.addAttribute("listaPrendas", coService.listar());			
				return "garmentpersonalized";
			}
		else {
			boolean flag = ccService.Registrar(objGarmentPersonalized);
			if (flag)
				return "redirect:/garmentpersonalized/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/garmentpersonalized/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException 
	{
		Optional<GarmentPersonalized> objGarmentPersonalized = ccService.buscarId(id);
		if (objGarmentPersonalized == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/garmentpersonalized/listar";
		}
		else {
			model.addAttribute("listaClientes", cuService.listar());
			model.addAttribute("listaPrendas", coService.listar());				
					
			if (objGarmentPersonalized.isPresent())
				objGarmentPersonalized.ifPresent(o -> model.addAttribute("garmentpersonalized", o));
			
			return "garmentpersonalized";
		}
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				ccService.eliminar(id);
				model.put("listaPrendaPersonalizadas", ccService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un roche");
			model.put("listaPrendaPersonalizadas", ccService.listar());
			
		}
		return "listGarmentPersonalized";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPrendaPersonalizadas", ccService.listar());
		return "listGarmentPersonalized";
	}		
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute GarmentPersonalized garmentpersonalized) 
	throws ParseException
	{
		ccService.listarId(garmentpersonalized.getIdGarmentPersonalized());
		return "listGarmentPersonalized";
	}	
	
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("garmentpersonalized", new GarmentPersonalized());
		return "buscar";
	}	
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute GarmentPersonalized garmentpersonalized)
			throws ParseException
	{
		List<GarmentPersonalized> listaPrendaPersonalizadas;
		garmentpersonalized.setUrlimageGarmentPersonalized(garmentpersonalized.getUrlimageGarmentPersonalized());
		listaPrendaPersonalizadas = ccService.buscarUrl(garmentpersonalized.getUrlimageGarmentPersonalized());
		
		if(listaPrendaPersonalizadas.isEmpty())
		{
			listaPrendaPersonalizadas=ccService.buscarCliente(garmentpersonalized.getUrlimageGarmentPersonalized());
		}
		
		if (listaPrendaPersonalizadas.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaPrendaPersonalizadas", listaPrendaPersonalizadas);		
		return "buscar";
	}		
	
}
