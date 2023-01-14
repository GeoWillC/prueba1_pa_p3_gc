package com.example.demo.banco.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.modelo.Cuenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CuentaRepoImpl implements ICuentaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuenta);
	}

	@Override
	public Cuenta buscar(String id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cuenta.class, id);
	}

	@Override
	public void eliminar(String id) {
		// TODO Auto-generated method stub
		Cuenta cuenta =this.buscar(id);
		this.entityManager.remove(cuenta);
	}

}
