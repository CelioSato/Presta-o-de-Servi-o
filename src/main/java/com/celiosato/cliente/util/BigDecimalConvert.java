package com.celiosato.cliente.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BigDecimalConvert {
	
	public BigDecimal convert (String valor) {
		if(valor == null) {
			return null;
		}
		
		valor = valor.replace(".", "").replace(",", ".");
		
		return new BigDecimal(valor);
		
	}

}
