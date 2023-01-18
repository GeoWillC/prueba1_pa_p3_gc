package com.example.demo.correcion.service;

import com.example.demo.correcion.modelo.*;


public interface ICuentaServiceCorr {
	public void guardar(CuentaCorreccion cuentaOrigen);
	public void modificar(CuentaCorreccion cuenta);
	public CuentaCorreccion encontrar(String numero);
	public void borrar(String numero);
}
