package br.com.compasso.rocket.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Cliente {
	@JacksonXmlProperty(localName = "nome")
	private String nome;
	@JacksonXmlProperty(localName = "cpf")
	private String cpf;
	
	public Cliente() {
	}
	
	@Override
	public String toString() {
		return "Cliente [Nome: " + this.nome + ", CPF: " + this.cpf + "]";
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			System.err.println("Nome inválido!");
		}
		else {
			this.nome = nome;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}