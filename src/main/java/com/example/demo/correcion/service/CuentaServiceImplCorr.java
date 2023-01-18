package com.example.demo.correcion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.correcion.modelo.*;
import com.example.demo.correcion.repository.ICuentaRepo;

@Service
public class CuentaServiceImplCorr implements ICuentaServiceCorr{

	@Autowired
	private ICuentaRepo iCuentaRepoCorr;
	
	@Override
	public void guardar(CuentaCorreccion cuenta) {
		// TODO Auto-generated method stub
		this.iCuentaRepoCorr.insertar(cuenta);
	}

	@Override
	public void modificar(CuentaCorreccion cuenta) {
		// TODO Auto-generated method stub
		this.iCuentaRepoCorr.actualizar(cuenta);
	}

	@Override
	public CuentaCorreccion encontrar(String numero) {
		// TODO Auto-generated method stub
		return this.iCuentaRepoCorr.buscar(numero);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.iCuentaRepoCorr.eliminar(numero);
	}
	

}
