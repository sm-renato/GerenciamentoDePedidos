package br.com.compasso.rocket.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Pedido {
	@JacksonXmlProperty(localName = "cliente")
	private Cliente cliente;
	@JacksonXmlProperty(localName = "produto")
	private Produto produto;
	@JacksonXmlProperty(localName = "quantidade")
	private int quantidade;
	@JacksonXmlProperty(localName = "valorDaCompra")
	private int valorDaCompra;
	
	public Pedido() {
	}
	
	@Override
	public String toString() {
		return "Pedido [ " + this.cliente + " | " + this.produto + " | " + this.quantidade + " | " + this.valorDaCompra
				+ " ]";
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}