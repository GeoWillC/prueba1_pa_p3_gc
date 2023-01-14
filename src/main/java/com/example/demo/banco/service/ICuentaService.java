package com.example.demo.banco.service;

import com.example.demo.banco.modelo.Cuenta;

public interface ICuentaService {

	//CRUD
	public void crear(Cuenta cuenta);
	public void actualizar(Cuenta cuenta);
	public Cuenta buscar(String numero);
	public void borrar(String numero);
}
