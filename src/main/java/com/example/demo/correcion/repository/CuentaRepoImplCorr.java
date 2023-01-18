package com.example.demo.correcion.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.correcion.modelo.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaRepoImplCorr implements ICuentaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CuentaCorreccion cuenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuenta);
	}

	@Override
	public void actualizar(CuentaCorreccion cuenta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuenta);
	}

	@Override
	public CuentaCorreccion buscar(String numero) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaCorreccion.class, numero);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		CuentaCorreccion cuenta=this.buscar(numero);
		this.entityManager.remove(cuenta);
	}
	

}
