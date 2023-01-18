package com.example.demo.correcion.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.correcion.modelo.TransferenciaCorreccion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class TransferenciaRepoImplCorr implements ITransferenciaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(TransferenciaCorreccion transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}
	@Override
	public void actualizar(TransferenciaCorreccion transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(transferencia);
	}
	@Override
	public TransferenciaCorreccion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(TransferenciaCorreccion.class, id);
	}
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		TransferenciaCorreccion transferenciaCorreccion=this.buscar(id);
		this.entityManager.remove(transferenciaCorreccion);;
		
	}
	
}
