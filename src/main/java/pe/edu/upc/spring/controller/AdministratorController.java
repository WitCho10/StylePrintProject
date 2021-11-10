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

import pe.edu.upc.spring.model.Administrator;
import pe.edu.upc.spring.model.Garment;
import pe.edu.upc.spring.service.IAdministratorService;
import pe.edu.upc.spring.service.IComplainxCustomerService;
import pe.edu.upc.spring.service.IGarmentService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {

	@Autowired
	private IAdministratorService aService;
	
	@Autowired
	private IGarmentService gService;
	@Autowired
	private IComplainxCustomerService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		//model.addAttribute("administrator", new Administrator());
		return "Administrador/LoginAdmi";
	}
	@RequestMapping("/perfil")
	public String irPerfil(Model model) {
		model.addAttribute("administrator", new Administrator());
		return "Administrador/PerfilAdmi";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaAdministradores",aService.listar());
		return "listAdministrator";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("prenda", new Garment());
		return "Administrador/prenda";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Administrator objAdministrator, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "administrator";
		else {
			boolean flag = aService.Registrar(objAdministrator);
			if(flag)
				return "redirect:/administrator/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/administrator/irRegistrar";				
			}			
		}		
	}
	@RequestMapping("/prenda")
	public String registrarPrenda(@ModelAttribute Garment objPrenda, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "Administrador/prenda";
		else {
			boolean flag = gService.Registrar(objPrenda);
			if(flag)
				return "redirect:/administrator/listPrenda";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/administrator/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Administrator> objAdministrator = aService.listarId(id);
		if(objAdministrator == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/administrator/listar";
		}
		else {
			model.addAttribute("administrator", objAdministrator);
			return "administrator";
		}
	}
	@RequestMapping("/modificarPrenda/{id}")
	public String modificarPrenda(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
//		Optional<Administrator> objAdministrator = aService.listarId(id);
		Optional<Garment> objGarment = gService.listarId(id);
		if(objGarment== null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/administrator/listPrenda";
		}
		else {
			model.addAttribute("garment", objGarment);
			return "administrator/registrar";
		}
//		if(objAdministrator == null) {
//			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
//			return "redirect:/administrator/listar";
//		}
//		else {
//			model.addAttribute("administrator", objAdministrator);
//			return "administrator";
//		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				aService.eliminar(id);
				model.put("listaAdministradores", aService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaAdministradores", aService.listar());
		}
		return "listAdministrator";
	}
	@RequestMapping("/listPrenda")
	public String listarPrendas(Map<String, Object> model) {
		model.put("listaPrendas",gService.listar());
		return "Administrador/listPrenda";
	}
	@RequestMapping("/listQueja")
	public String listarQuejas(Map<String, Object> model) {
		model.put("listaQuejasCliente",cService.listar());
		return "Administrador/listQueja";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaAdministradores", aService.listar());
		return "listAdministrator";
		
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Administrator administrator)
			throws ParseException
	{
		List<Administrator> listaAdministradores;
		administrator.setNameAdministrator(administrator.getNameAdministrator());
		listaAdministradores = aService.buscarNombre(administrator.getNameAdministrator());
		
		
		if (listaAdministradores.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaAdministradores", listaAdministradores);		
		return "buscar";
	}	
	
}
