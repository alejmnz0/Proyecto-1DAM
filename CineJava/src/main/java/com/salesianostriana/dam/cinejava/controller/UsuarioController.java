package com.salesianostriana.dam.cinejava.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.cinejava.model.Asiento;
import com.salesianostriana.dam.cinejava.model.Entrada;
import com.salesianostriana.dam.cinejava.model.Pelicula;
import com.salesianostriana.dam.cinejava.model.Usuario;
import com.salesianostriana.dam.cinejava.service.AjustesService;
import com.salesianostriana.dam.cinejava.service.EntradaService;
import com.salesianostriana.dam.cinejava.service.PeliculaService;
import com.salesianostriana.dam.cinejava.service.SalaService;
import com.salesianostriana.dam.cinejava.service.UsuarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService servicioUsuario;
	@Autowired
	private PeliculaService servicioPeli;
	@Autowired
	private SalaService servicioSala;
	@Autowired
	private AjustesService servicioAjustes;
	@Autowired
	private EntradaService servicioEntrada;

	@GetMapping("/login")
	public String mandarLogin() {
		return "login";
	}

	@GetMapping({ "/" })
	public String listarTodos(Model model) {
		model.addAttribute("lista", servicioPeli.findAll());
		return "index";
	}

	@GetMapping("/me")
	public String me() {

		Usuario u = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println(u.toString());

		return "index";
	}

	@GetMapping("/me2")
	public String me2(@AuthenticationPrincipal Usuario u) {

		System.out.println(u.toString());

		return "index";
	}

	@GetMapping("/register")
	public String registro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "userRegister";
	}

	@PostMapping("/register/submit")
	public String procesarRegistro(@ModelAttribute("usuario") Usuario u) {
		servicioUsuario.add(u);
		return "redirect:/login/";
	}

	@GetMapping("/información")
	public String mostrarAboutUs() {
		return "info";
	}

	@GetMapping("/información/salas")
	public String mostrarInfoSalas() {
		return "infosalas";
	}

	@GetMapping("/comprar/{id}")
	public String comprar(@PathVariable("id") long id, Model model) {

		Pelicula aMostrar = servicioPeli.findById(id).get();

		model.addAttribute("lista", servicioSala.findPaseByFilm(aMostrar));
		model.addAttribute("pelicula", aMostrar);
		return "comprar";
	}

	@GetMapping("/comprar/pase/{id}")
	public String comprarPase(@PathVariable("id") long idPase, Model model) {

		model.addAttribute("asientos", comprobarDisponibilidad(servicioSala.findAsientosByPase(idPase),idPase));
		model.addAttribute("paseId", idPase);
		model.addAttribute("asientosSeleccionados", new ArrayList<Asiento>());
		model.addAttribute("ajustes", servicioAjustes.findById(1).get());
		return "asientoForm";
	}

	@PostMapping("/comprar/pase/submit")
	public String comprarEntrada(@RequestParam("asientosSeleccionadosInput") String asientosSeleccionados,
			@RequestParam("idPase") Long idPase, Model model) {

		List<Long> asientosIds = Arrays.stream(asientosSeleccionados.split(",")).map(Long::parseLong)
				.collect(Collectors.toList());

		int cantidadEntradas = asientosIds.size(),vips=0,normales=0;
		double precioTotal = 0;
		double precio;

		for (Long id : asientosIds) {
			precio = calcularPrecioVip(id);
			precio = calcularPrecioDia(idPase, precio);
			
			if(servicioSala.findAsientoById(id).isVip())
				vips++;
			else
				normales++;

			Entrada e = Entrada.builder().pase(servicioSala.findPaseById(idPase))
					.asiento(servicioSala.findAsientoById(id)).precio(precio).build();
			servicioEntrada.save(e);
			precioTotal += precio;
		}
		precioTotal = calcularPrecioTotal(asientosIds.size(),precioTotal);
		model.addAttribute("cantVips", vips);
		model.addAttribute("cantNormales", normales);
		model.addAttribute("gratuitas", cantidadEntradas/servicioAjustes.findCantEntradasParaGratisById(1));
		model.addAttribute("cantidadXGratis", servicioAjustes.findCantEntradasParaGratisById(1));
		model.addAttribute("cantidadEntradas", cantidadEntradas);
		model.addAttribute("diaDescuento", (servicioAjustes.findDiaDescuentoById(1)
				.equalsIgnoreCase(servicioSala.findPaseById(idPase).getFecha().getDayOfWeek().toString())));
		model.addAttribute("descuento", servicioAjustes.findPorcentDescuentoById(1));
		model.addAttribute("precioTotal", precioTotal);
		return "ticket";
	}

	// Helpers

	public double calcularPrecioVip(Long idAsiento) {
		return (servicioSala.findAsientoById(idAsiento).isVip())
				? servicioAjustes.findPrecioById(1) + servicioAjustes.findPrecioVipById(1)
				: servicioAjustes.findPrecioById(1);
	}

	public double calcularPrecioDia(Long idPase, double precio) {
		return (servicioAjustes.findDiaDescuentoById(1)
				.equalsIgnoreCase(servicioSala.findPaseById(idPase).getFecha().getDayOfWeek().toString()))
						? (precio * (1 - servicioAjustes.findPorcentDescuentoById(1) / 100))
						: precio;
	}
	
	public double calcularPrecioTotal (int cantEntradas,double precioTotal) {
		System.out.println(cantEntradas/servicioAjustes.findCantEntradasParaGratisById(1));
		return precioTotal-servicioAjustes.findPrecioById(1)*(cantEntradas/servicioAjustes.findCantEntradasParaGratisById(1));
	}
	
	public List<Asiento> comprobarDisponibilidad (List<Asiento> asientos, long idPase){
		for (Asiento asiento : asientos) {
			Optional<Entrada> entrada = servicioEntrada.findEntradaVendida(asiento.getId(), idPase);
			if(entrada.isPresent()) {
				asiento.setDisponible(false);
			}
		}
		return asientos;
	}

}
