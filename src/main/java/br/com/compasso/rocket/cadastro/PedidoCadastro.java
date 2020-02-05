package br.com.compasso.rocket.cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.rocket.models.Pedido;

@JacksonXmlRootElement(localName = "PedidoCadastro")
public class PedidoCadastro implements Cadastro<Pedido> {

	@JacksonXmlProperty(localName = "pedido")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	@Override
	public void cadastra(Scanner scan) {
		int voltar = 1;
		do {
			voltar = menuDaOpcao("realizar um pedido", scan, voltar);
			
			if (voltar != 0) {
//				TODO RealizaPedido(scan);
			}

		} while (voltar != 0);
	}

	public List<Pedido> getPedidos() {
		return Collections.unmodifiableList(pedidos);
	}
}
