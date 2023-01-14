package com.example.demo.banco.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name="transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_sec")
	@SequenceGenerator(name = "tran_sec",sequenceName = "tran_sec",allocationSize = 1)
	@Column(name="tran_id")
	private Integer Id;
	@Column(name="tran_fecha_transferencia")
	private LocalDateTime fechaTransferencia;
	@Column(name="tran_numero_cuenta_origen")
	private String numeroCuentaOrigen;
	@Column(name="tran_numero_cuenta_destino")
	private String numeroCuentaDestino;
	@Column(name="tran_monto_transferencia")
	private BigDecimal montoTransferencia;
	@Column(name = "tran_comision_tranferencia")
	private BigDecimal comisionTransferencia;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public LocalDateTime getFechaTransferencia() {
		return fechaTransferencia;
	}
	public void setFechaTransferencia(LocalDateTime fechaTransferencia) {
		this.fechaTransferencia = fechaTransferencia;
	}
	public String getNumeroCuentaOrigen() {
		return numeroCuentaOrigen;
	}
	public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
		this.numeroCuentaOrigen = numeroCuentaOrigen;
	}
	public String getNumeroCuentaDestino() {
		return numeroCuentaDestino;
	}
	public void setNumeroCuentaDestino(String numeroCuentaDestino) {
		this.numeroCuentaDestino = numeroCuentaDestino;
	}
	public BigDecimal getMontoTransferencia() {
		return montoTransferencia;
	}
	public void setMontoTransferencia(BigDecimal montoTransferencia) {
		this.montoTransferencia = montoTransferencia;
	}
	public BigDecimal getComisionTransferencia() {
		return comisionTransferencia;
	}
	public void setComisionTransferencia(BigDecimal comisionTransferencia) {
		this.comisionTransferencia = comisionTransferencia;
	}
	@Override
	public String toString() {
		return "Transferencia [Id=" + Id + ", fechaTransferencia=" + fechaTransferencia + ", numeroCuentaOrigen="
				+ numeroCuentaOrigen + ", numeroCuentaDestino=" + numeroCuentaDestino + ", montoTransferencia="
				+ montoTransferencia + ", comisionTransferencia=" + comisionTransferencia + "]";
	}
		
	
}
