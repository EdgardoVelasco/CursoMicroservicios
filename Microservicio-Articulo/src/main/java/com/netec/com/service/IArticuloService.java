package com.netec.com.service;

import java.util.List;

import com.netec.com.entities.Articulo;

public interface IArticuloService {
	Articulo save(Articulo a);
	void deleteById(int id);
	Articulo findById(int id);
	List<Articulo> findByMarca(String marca);
	List<Articulo> findAll();

}
