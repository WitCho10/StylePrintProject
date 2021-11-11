package pe.edu.upc.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Complain;
import pe.edu.upc.spring.model.ComplainxCustomer;
import pe.edu.upc.spring.model.Customer;
import pe.edu.upc.spring.model.Garment;
import pe.edu.upc.spring.model.GarmentPosition;
import pe.edu.upc.spring.service.IComplainService;
import pe.edu.upc.spring.service.IComplainxCustomerService;
import pe.edu.upc.spring.service.ICustomerService;
import pe.edu.upc.spring.service.IGarmentPositionService;
import pe.edu.upc.spring.service.IGarmentService;
import pe.edu.upc.spring.service.ISizeService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService cService;
	
	@Autowired
	private IComplainService coService;
	
	@Autowired
	private IGarmentService gService;
	
	@Autowired
	private ISizeService siService;
	
	@Autowired
	private IComplainxCustomerService ccService;
	
	@Autowired
	private IGarmentPositionService gpService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida(Model model) {
		model.addAttribute("customer",new Customer());
		return "Cliente/LoginCliente";
	}
	@RequestMapping("/perfil")
	public String irPaginaInicio(Model model) {
		model.addAttribute("customer", new Customer());
		return "Cliente/PerfilCliente";
	}
	@RequestMapping("/productos")
	public String irListadoDeProductos(Map<String,Object> model) {
		model.put("listaProductos", gService.listar());
		return "Cliente/listProductos";
	}
	//	@PostMapping("/bienvenido")
//	public String Login(@ModelAttribute("customer") Customer customer ) {
//		Customer authCustomer = cService.login(customer.getEmailCustomer(),customer.getPasswordCustomer());
//		System.out.print("authCustomer");
//		if(Objects.nonNull(authCustomer)) {
//			return "redirect:/Customer/perfil";
//		}else {
//			return "redirect:/Customer/bienvenido";
//		}
//			
//	}
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String,Object> model) {
		model.put("listaClientes",cService.listar());
		return "listCustomer";
	}
	@RequestMapping("/nuevaCompra/{id}")
	public String RealizarCompra(@PathVariable int id,Model model, RedirectAttributes objRedir,@ModelAttribute Garment objG) throws ParseException{
		//Optional<Customer> objCustomer =
		//model.addAttribute("customer", new Customer());
		//model.addAttribute("garment", new Garment());
		//Optional<Garment> objGarment= gService.listarId(id);
//		if(objGarment ==null) {
//			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
//			return "redirect:/petasd";
//		}else {
			//model.addAttribute("customer", new Customer());
			Optional<Garment> objGarment = gService.listarId(id);
			if(objGarment == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/administrator/productos";
			}
			else {
				
				//model.addAttribute("garment", new Garment());
				model.addAttribute("customer", new Customer());
				model.addAttribute("listaPosiciones",gpService.listar());
				model.addAttribute("listaTallas", siService.listar());
				
				if(objGarment.isPresent()) {
					objGarment.ifPresent(o->model.addAttribute("prenda",o));					
				}
				return "Cliente/RealizarCompra";	
			}
//			if(objGarment.isPresent())
//				objGarment.ifPresent(o-> model.addAttribute("Garment",o));					
	}
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<Customer> objCustomer = cService.listarId(id);
		if(objCustomer == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/customer/bienvenido";
		}
		else {
			model.addAttribute("customer", objCustomer);
			return "Cliente/EditarPerfil";
		}
	}
	
	@RequestMapping("/queja")
	public String RealizarQueja(Model model) {
		model.addAttribute("customer",new Customer());
		model.addAttribute("complain", new Complain());
		model.addAttribute("Queja", new ComplainxCustomer());
		model.addAttribute("listaQuejas", coService.listar());
		model.addAttribute("listaClientes", cService.listar());
		return "Cliente/RealizarQueja";
	}
	@RequestMapping("/registrarQueja")
	public String IngresarQueja(@ModelAttribute ComplainxCustomer objCC, BindingResult binRes,Model model) {
		//model.addAttribute("Queja",new ComplainxCustomer());
		if(binRes.hasErrors()) {
			model.addAttribute("listaQuejas", coService.listar());
			model.addAttribute("listaClientes", cService.listar());
			return "Administrador/queja";
		}
		//model.addAttribute("Queja", new Complain());
		else {
			boolean flag= ccService.Registrar(objCC);
			if(flag)
				return "redirect:/administrator/perfil";
			else {
				model.addAttribute("mensaje", "ocurrio un error");
				return "redirect:/administrator/irRegistrar";
			}
			
		}		
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("customer", new Customer());
		return "Cliente/CrearCuentaCliente";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Customer objCustomer, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors())
			return "customer";
		else {
			boolean flag = cService.Registrar(objCustomer);
			if(flag)
				return "redirect:/customer/bienvenido";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/customer/irRegistrar";				
			}			
		}		
	}
	
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cService.eliminar(id);
				model.put("listaClientes", cService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaClientes", cService.listar());
		}
		return "listCustomer";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaClientes", cService.listar());
		return "listCustomer";
		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("customer", new Customer());
		return "buscar";
	}	
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Customer customer)
			throws ParseException
	{
		List<Customer> listaClientes;
		customer.setNameCustomer(customer.getNameCustomer());
		listaClientes = cService.buscarNombre(customer.getNameCustomer());
		
		
		if (listaClientes.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaClientes", listaClientes);		
		return "buscar";
	}		
	
	
}
