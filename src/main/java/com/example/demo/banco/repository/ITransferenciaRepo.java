package com.example.demo.banco.repository;

import com.example.demo.banco.modelo.Transferencia;

public interface ITransferenciaRepo {

	//CRUD
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public Transferencia buscar(String id);
	public void eliminar(String id);
}
