package br.com.compasso.rocket.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Produto {
	@JacksonXmlProperty(localName = "codigo")
	private int codigo;
	@JacksonXmlProperty(localName = "descricao")
	private String descricao;
	@JacksonXmlProperty(localName = "preco")
	private double preco;
	@JacksonXmlProperty(localName = "quantidade")
	private int quantidade; // estoque

	public Produto() {
	}

	@Override
	public String toString() {
		return "Produto [ cód" + this.codigo + " - " + this.descricao + ", preço: R$" + this.preco + "] - "
				+ this.quantidade + " un";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo < 0) {
			System.err.println("Código inválido!");
		} else {
			this.codigo = codigo;
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			System.err.println("Descricao inválida!");
		} else {
			this.descricao = descricao;
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco < 0.01) {
			System.err.println("Preço inválido!");
		} else {
			this.preco = preco;
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if (quantidade < 1) {
			System.err.println("Quantidade inválida!");
		} else {
			this.quantidade = quantidade;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}