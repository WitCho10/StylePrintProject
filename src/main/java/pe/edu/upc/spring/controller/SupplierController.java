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

import pe.edu.upc.spring.model.Supplier;
import pe.edu.upc.spring.service.ISupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private ISupplierService sService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaProveedores",sService.listar());
		return "listSupplier";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("supplier", new Supplier());
		return "supplier";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Supplier objSupplier, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "supplier";
		else {
			boolean flag = sService.Registrar(objSupplier);
			if(flag)
				return "redirect:/supplier/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/supplier/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Supplier> objSupplier = sService.listarId(id);
		if(objSupplier == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/supplier/listar";
		}
		else {
			model.addAttribute("supplier", objSupplier);
			return "supplier";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				sService.eliminar(id);
				model.put("listaProveedores", sService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaProveedores", sService.listar());
		}
		return "listSupplier";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaProveedores", sService.listar());
		return "listSupplier";
		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("supplier", new Supplier());
		return "buscar";
	}	
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Supplier supplier)
			throws ParseException
	{
		List<Supplier> listaProveedores;
		supplier.setNameSupplier(supplier.getNameSupplier());
		listaProveedores = sService.buscarNombre(supplier.getNameSupplier());
		
		
		if (listaProveedores.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaProveedores", listaProveedores);		
		return "buscar";
	}	
}
