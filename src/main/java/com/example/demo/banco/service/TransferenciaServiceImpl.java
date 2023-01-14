package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.modelo.Cuenta;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.repository.ITransferenciaRepo;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaService iCuentaService;

	@Autowired
	private ITransferenciaRepo iTransferenciaRepo;

	@Override
	public void realizar(String origen, String destino, BigDecimal monto) {
		Transferencia transferencia = new Transferencia();
		transferencia.setFechaTransferencia(LocalDateTime.now());
		transferencia.setNumeroCuentaOrigen(origen);
		transferencia.setNumeroCuentaDestino(destino);
		transferencia.setMontoTransferencia(monto);
		Cuenta cuentaOrigen = this.iCuentaService.buscar(destino);
		Cuenta cuentaDestino = this.iCuentaService.buscar(origen);
		// Transferencia
		// Saldo negativo
		if (cuentaOrigen.getSaldo().compareTo(monto) > 1) {
			cuentaOrigen.getSaldo().subtract(monto);
			cuentaDestino.getSaldo().add(monto);
			this.iCuentaService.actualizar(cuentaOrigen);
			this.iCuentaService.actualizar(cuentaDestino);

			// Comision
			BigDecimal comision = monto.multiply(new BigDecimal(0.05));
			transferencia.setComisionTransferencia(comision);
			this.iTransferenciaRepo.insertar(transferencia);
		} else {
			System.out.println("El valor del origen no es suficiente para realizar la transaccion");
		}

		// Buscar e imprimir el origen

		System.out.println("El saldo actual de la cuenta origen es:" + iCuentaService.buscar(origen));
	}

}
