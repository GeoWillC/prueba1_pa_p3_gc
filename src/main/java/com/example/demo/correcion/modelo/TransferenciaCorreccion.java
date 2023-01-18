package com.example.demo.correcion.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transfer")
public class TransferenciaCorreccion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_sec")
	@SequenceGenerator(name = "tran_sec", sequenceName = "tran_Sec",allocationSize = 1)
	@Column(name = "tran_id")
	private Integer id;
	@Column(name = "tran_fecha")
	private LocalDateTime fechaTransferencia;
	@Column(name = "tran_origen")
	private String cuentaOrigen;
	@Column(name = "tran_destino")
	private String cuentaDestino;
	@Column(name = "tran_monto")
	private BigDecimal monto;
	@Column(name = "tran_comision")
	private BigDecimal comision;

	// GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaTransferencia() {
		return fechaTransferencia;
	}

	public void setFechaTransferencia(LocalDateTime fechaTransferencia) {
		this.fechaTransferencia = fechaTransferencia;
	}

	public String getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(String cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public String getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(String cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getComision() {
		return comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fechaTransferencia=" + fechaTransferencia + ", cuentaOrigen="
				+ cuentaOrigen + ", cuentaDestino=" + cuentaDestino + ", monto=" + monto + ", comision=" + comision
				+ "]";
	}

}
