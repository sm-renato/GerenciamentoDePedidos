package br.com.compasso.rocket.services;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;

public class Documentos {

	public String formataCpf(String documento) {
		CPFFormatter formatadorCPF = new CPFFormatter();
		try {
			return formatadorCPF.unformat(documento);
		} catch (Exception e) {
			return documento;
		}
	}

	public boolean validaCpf(String documento) {
		try {
			CPFValidator validador = new CPFValidator();
			validador.assertValid(documento);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}