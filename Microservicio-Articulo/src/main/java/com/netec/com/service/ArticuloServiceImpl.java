package com.netec.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netec.com.dao.IArticuloDAO;
import com.netec.com.entities.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService{
	@Autowired
	private IArticuloDAO dao;

	@Override
	public Articulo save(Articulo a) {
		return dao.save(a);
	}

	@Override
	public void deleteById(int id) {
		if(dao.existsById(id)) {
			dao.deleteById(id);
		}else {
			throw new RuntimeException("No existe id: "+id);
		}
		
	}

	@Override
	public Articulo findById(int id) {
		return dao.findById(id).orElse(new Articulo());
	}

	@Override
	public List<Articulo> findByMarca(String marca) {
		
		return dao.findByMarca(marca).orElse(new ArrayList<Articulo>());
	}

	@Override
	public List<Articulo> findAll() {
		return (List<Articulo>)dao.findAll();
	}
	
	

}
