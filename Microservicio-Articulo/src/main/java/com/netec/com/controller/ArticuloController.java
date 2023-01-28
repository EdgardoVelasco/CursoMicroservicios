package com.netec.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netec.com.entities.Articulo;
import com.netec.com.service.IArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
	@Autowired
	private IArticuloService servicio;
	
	@PostMapping
	public Articulo insert(@RequestBody Articulo a) {
		return servicio.save(a);
	}
	
	@DeleteMapping
	public void deleteById(@RequestParam(name = "id") int id) {
		servicio.deleteById(id);
	}
	
	@GetMapping("/marca/{marca}")
	public List<Articulo> searchByMarca(@PathVariable("marca") String marca){
		return servicio.findByMarca(marca);
	}
	
	@GetMapping("/{id}")
	public Articulo findById(@PathVariable("id") int id) {
		return servicio.findById(id);
	}
	
	@GetMapping
	public List<Articulo> findAll(){
		return servicio.findAll();
	}
	

}
