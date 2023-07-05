package com.app.crud.controlador;

import com.app.crud.ventas.copia.Ventas;
import com.app.crud.ventas.servicios.ventasservicioimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/ventas")
public class controlador {

	private final Logger log = LoggerFactory.getLogger(controlador.class);

	@Autowired
	private ventasservicioimpl servicio;

	@GetMapping("/listarcrud")
	public String listarVentas(Model model) {
		List<Ventas> ventas = servicio.listarVentas();
		model.addAttribute("ventas", ventas);
		return "index";
	}
	
	@GetMapping("/palabraclave")
	public String buscarPorPalabraClave(@RequestParam("palabraClave") String palabraClave, Model model) {
		List<Ventas> ventas = servicio.listar(palabraClave);
		model.addAttribute("ventas", ventas);
		model.addAttribute("palabraClave", palabraClave);
		return "index";
	}

	@GetMapping("/editar/{idVentas}")
	public String editar(@PathVariable Long idVentas, Model model) {
		Optional<Ventas> venta = servicio.listarPorId(idVentas);
		model.addAttribute("venta", venta.orElse(null));
		log.info("Venta objeto para editar: {}", venta);
		return "editar";
	}
	@GetMapping("/eliminar/{idVentas}")
	public String eliminarVenta(@PathVariable Long idVentas) {
		servicio.delete(idVentas);
		return "redirect:/ventas/listarcrud";
	}

	@GetMapping("/nuevoVenta")
	public String mostrarFormularioVenta(Model model) {
		model.addAttribute("venta", new Ventas());
		return "agregarVenta";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@PostMapping("/guardarVenta")
	public String guardarVenta(@ModelAttribute Ventas venta) {
		servicio.guardarVenta(venta);
		log.info("Venta informacion: {}", venta);
		return "redirect:/ventas/listarcrud";
	}

	 @GetMapping({ "/inicio", "/" })
		public String inicio(Model model) {			
			return "inicio";
		}
}
