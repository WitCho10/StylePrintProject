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

import pe.edu.upc.spring.model.Complain;
import pe.edu.upc.spring.model.ComplainxCustomer;
import pe.edu.upc.spring.model.Customer;
import pe.edu.upc.spring.service.IComplainService;
import pe.edu.upc.spring.service.IComplainxCustomerService;
import pe.edu.upc.spring.service.ICustomerService;

@Controller
@RequestMapping("/complainxcustomer")
public class ComplainxCustomerController {

	@Autowired
	private IComplainxCustomerService ccService;
	
	@Autowired
	private IComplainService coService;
	
	@Autowired
	private ICustomerService cuService;	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "MenuCliente";
	}
		
	@RequestMapping("/")
	public String irPaginaListadoMascotas(Map<String, Object> model) {
		model.put("listaQuejasxClientes", ccService.listar());
		return "listComplainxCustomer";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("complain", new Complain());
		model.addAttribute("complainxcustomer", new ComplainxCustomer());
		
//		model.addAttribute("listaClientes", cuService.listar());
		model.addAttribute("listaQuejas", coService.listar());		
		
		return "complainxcustomer";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute ComplainxCustomer objComplainxCustomer, BindingResult binRes, Model model)
			throws ParseException
	{
		if (binRes.hasErrors()) 
			{
			model.addAttribute("listaClientes", cuService.listar());
			model.addAttribute("listaQuejas", coService.listar());			
				return "complainxcustomer";
			}
		else {
			boolean flag = ccService.Registrar(objComplainxCustomer);
			if (flag)
				return "redirect:/complainxcustomer/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/complainxcustomer/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException 
	{
		Optional<ComplainxCustomer> objComplainxCustomer = ccService.buscarId(id);
		if (objComplainxCustomer == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/complainxcustomer/listar";
		}
		else {
			model.addAttribute("listaClientes", cuService.listar());
			model.addAttribute("listaQuejas", coService.listar());			
					
			if (objComplainxCustomer.isPresent())
				objComplainxCustomer.ifPresent(o -> model.addAttribute("complainxcustomer", o));
			
			return "complainxcustomer";
		}
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				ccService.eliminar(id);
				model.put("listaQuejasxClientes", ccService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un roche");
			model.put("listaQuejasxClientes", ccService.listar());
			
		}
		return "listComplainxCustomer";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaQuejasxClientes", ccService.listar());
		return "listComplainxCustomer";
	}		
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute ComplainxCustomer complainxCustomer) 
	throws ParseException
	{
		ccService.listarId(complainxCustomer.getIdComplainxCustomer());
		return "listComplainxCustomer";
	}	
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("complainxCustomer", new ComplainxCustomer());
		return "buscar";
	}	
	
//	@RequestMapping("/buscar")
//	public String buscar(Map<String, Object> model, @ModelAttribute ComplainxCustomer complainxCustomer)
//			throws ParseException
//	{
//		List<ComplainxCustomer> listaQuejasxClientes;
//		complainxCustomer.setAffairComplainxCustomer(complainxCustomer.getAffairComplainxCustomer());
//		listaQuejasxClientes = ccService.buscarAsunto(complainxCustomer.getAffairComplainxCustomer());
//		
//		if(listaQuejasxClientes.isEmpty())
//		{
//			
//			listaQuejasxClientes=ccService.buscarCliente(complainxCustomer.getAffairComplainxCustomer());
//		}
//		if(listaQuejasxClientes.isEmpty())
//		{
//			listaQuejasxClientes=ccService.buscarQueja(complainxCustomer.getAffairComplainxCustomer());
//		}
//		if (listaQuejasxClientes.isEmpty()) {
//			model.put("mensaje", "No existen coincidencias");
//		}
//		
//		model.put("listaQuejasxClientes", listaQuejasxClientes);		
//		return "buscar";
//	}		
	
	
}
