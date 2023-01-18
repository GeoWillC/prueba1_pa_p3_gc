package com.example.demo.correcion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.correcion.modelo.CuentaCorreccion;
import com.example.demo.correcion.modelo.TransferenciaCorreccion;
import com.example.demo.correcion.repository.ITransferenciaRepo;

@Service
public class TransferenciaServiceImplCorr implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepo iTransferenciaRepoCorr;
	@Autowired
	private ICuentaServiceCorr iCuentaServiceCorr;

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		// Origen
		CuentaCorreccion origen = this.iCuentaServiceCorr.encontrar(numeroOrigen);
		BigDecimal comision = monto.multiply(new BigDecimal(0.05));
		BigDecimal montoDebitar = monto.add(comision);
		BigDecimal saldoActualOrigen = origen.getSaldo();

		// -1 si el de la izquierda en menor
		// 1 si el de la izquierda es mayor
		//0 Ambos valores son iguales 
		//Caso contrario
//		if (saldoActualOrigen.compareTo(montoDebitar) > 0) {
//			codigo
//		} else {
//			syso("Monto no permitido")			
		
		// Implica que el saldo actual es menor al moonto a debitar
		if (saldoActualOrigen.compareTo(montoDebitar) < 0) {
			System.out.println("Monto no permitido");
		} else {
		
			
			// Origen
			origen.setSaldo(saldoActualOrigen.subtract(montoDebitar));
			this.iCuentaServiceCorr.modificar(origen);
			// Destino
			CuentaCorreccion destino = this.iCuentaServiceCorr.encontrar(numeroDestino);
			BigDecimal saldoActualDestino = destino.getSaldo();

			destino.setSaldo(saldoActualDestino.add(monto));

			this.iCuentaServiceCorr.modificar(destino);

			// Transferencia
			TransferenciaCorreccion transferencia = new TransferenciaCorreccion();

			transferencia.setComision(comision);
			transferencia.setCuentaDestino(numeroOrigen);
			transferencia.setCuentaOrigen(numeroOrigen);
			transferencia.setFechaTransferencia(LocalDateTime.now());
			transferencia.setMonto(monto);

			this.iTransferenciaRepoCorr.insertar(transferencia);
		}

	}

}
