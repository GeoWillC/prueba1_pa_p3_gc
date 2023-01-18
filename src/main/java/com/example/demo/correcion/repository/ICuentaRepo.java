package com.example.demo.correcion.repository;

import com.example.demo.correcion.modelo.*;

public interface ICuentaRepo {
	public void insertar(CuentaCorreccion cuenta);
	public void actualizar(CuentaCorreccion cuenta);
	public CuentaCorreccion buscar(String numero);
	public void eliminar(String numero);
	
}
