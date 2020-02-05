package br.com.compasso.rocket.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.compasso.rocket.cadastro.PedidoCadastro;
import br.com.compasso.rocket.models.Pedido;

public class PedidoDAO implements BaseDAO<List<Pedido>> {

	private ObjectMapper mapper = new XmlMapper();
	private PedidoCadastro pedido;

	@Override
	public List<Pedido> desserealiza() throws IOException {
		File file = new File("Pedidos.xml");
		this.pedido = this.mapper.readValue(file, PedidoCadastro.class);
		return this.pedido.getPedidos();
	}

}