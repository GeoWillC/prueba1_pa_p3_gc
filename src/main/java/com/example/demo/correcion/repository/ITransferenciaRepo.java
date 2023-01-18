package com.example.demo.correcion.repository;

import com.example.demo.correcion.modelo.*;

public interface ITransferenciaRepo {
	public void insertar(TransferenciaCorreccion transferencia);
	public void actualizar(TransferenciaCorreccion cuenta);
	public TransferenciaCorreccion buscar(Integer id);
	public void eliminar(Integer id);
}
