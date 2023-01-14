package com.example.demo.banco.service;

import java.math.BigDecimal;

public interface ITransferenciaService {

	public void realizar(String origen, String destino, BigDecimal monto);

}
