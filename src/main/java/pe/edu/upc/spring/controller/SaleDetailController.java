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

import pe.edu.upc.spring.model.GarmentPersonalized;
import pe.edu.upc.spring.model.Sale;
import pe.edu.upc.spring.model.SaleDetail;
import pe.edu.upc.spring.service.IGarmentPersonalizedService;
import pe.edu.upc.spring.service.ISaleDetailService;
import pe.edu.upc.spring.service.ISaleService;

@Controller
@RequestMapping("/saledetail")
public class SaleDetailController {

	@Autowired
	private ISaleDetailService sService;
	
	@Autowired
	private ISaleService saService;
	
	@Autowired
	private IGarmentPersonalizedService gpService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEstados(Map<String, Object> model) {
		model.put("listaDetalleVentas",sService.listar());
		return "listSaleDetail";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("saledetail", new SaleDetail());
		model.addAttribute("sale", new Sale());
		model.addAttribute("garmentpersonalized", new GarmentPersonalized());
		
		model.addAttribute("listaVentas", saService.listar());
		model.addAttribute("listaPrendaPersonalizadas", gpService.listar());
		
		return "saledetail";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute SaleDetail objSaleDetail, BindingResult binRes, Model model) throws ParseException
	{
		if(binRes.hasErrors()) {
			model.addAttribute("listaVentas", saService.listar());
			model.addAttribute("listaPrendaPersonalizadas", gpService.listar());
			return "saledetail";
		}
		else {
			boolean flag = sService.Registrar(objSaleDetail);
			if(flag)
				return "redirect:/saledetail/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/saledetail/irRegistrar";				
			}			
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model , RedirectAttributes objRedir) throws ParseException
	{
		Optional<SaleDetail> objSaleDetail = sService.listarId(id);
		if(objSaleDetail == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/saledetail/listar";
		}
		else {
			model.addAttribute("listaVentas", saService.listar());
			model.addAttribute("listaPrendaPersonalizadas", gpService.listar());
			if (objSaleDetail.isPresent())
				objSaleDetail.ifPresent(o -> model.addAttribute("saledetail", o));
			
			return "saledetail";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				sService.eliminar(id);
				model.put("listaDetalleVentas", sService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaDetalleVentas", sService.listar());
		}
		return "listSaleDetail";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDetalleVentas", sService.listar());
		return "listSaleDetail";
	}
	
}
