package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.correcion.modelo.CuentaCorreccion;
import com.example.demo.correcion.service.ICuentaServiceCorr;
import com.example.demo.correcion.service.ITransferenciaService;

@SpringBootApplication
public class Prueba1PaP3GcApplication implements CommandLineRunner {

//	Prueba
//	@Autowired
//	private ITransferenciaService iTransferenciaService;
//	
//	@Autowired
//	private ICuentaService iCuentaService;
@Autowired
	private ICuentaServiceCorr iCuentaCorrecion;
@Autowired
	private ITransferenciaService iTransferenciaCorreccion;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba1PaP3GcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		//Prueba
//		// Cuenta 1
//		Cuenta cuenta1 = new Cuenta();
//		cuenta1.setNumero("5");
//		cuenta1.setCedula("1751252667");
//		cuenta1.setSaldo(new BigDecimal(50));
//		cuenta1.setTipo("C");
//		this.iCuentaService.crear(cuenta1);
//		// Cuenta 2
//		Cuenta cuenta2 = new Cuenta();
//		cuenta2.setNumero("6");
//		cuenta2.setSaldo(new BigDecimal(200));
//		cuenta2.setTipo("A");
//		this.iCuentaService.crear(cuenta2);
//		
//		iTransferenciaService.realizar(cuenta1.getNumero(), cuenta2.getNumero(), new BigDecimal(20));

		
		//Correccion
		CuentaCorreccion cuentaOrigen=new CuentaCorreccion();
		cuentaOrigen.setNumero("123");
		cuentaOrigen.setTipo("A");
		cuentaOrigen.setSaldo(new BigDecimal(100));
		cuentaOrigen.setCedualPropietario("12345678");
		this.iCuentaCorrecion.guardar(cuentaOrigen);
		
		CuentaCorreccion cuentaDestino=new CuentaCorreccion();
		cuentaDestino.setNumero("345");
		cuentaDestino.setTipo("A");
		cuentaDestino.setSaldo(new BigDecimal(200));
		cuentaDestino.setCedualPropietario("323456789");
		this.iCuentaCorrecion.guardar(cuentaDestino);
		
		iTransferenciaCorreccion.realizar("123", "345", new BigDecimal(10));
		System.out.println(this.iCuentaCorrecion.encontrar("123").getSaldo());
	}

}
