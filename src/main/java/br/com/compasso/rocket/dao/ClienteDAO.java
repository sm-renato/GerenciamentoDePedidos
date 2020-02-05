package br.com.compasso.rocket.dao;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.compasso.rocket.cadastro.ClienteCadastro;
import br.com.compasso.rocket.models.Cliente;

public class ClienteDAO implements BaseDAO<Set<Cliente>> {

	private ObjectMapper mapper = new XmlMapper();
	private ClienteCadastro cliente;
	
	@Override
	public Set<Cliente> desserealiza() throws IOException {
		File file = new File("Clientes.xml");
		this.cliente = this.mapper.readValue(file, ClienteCadastro.class);
		return this.cliente.getClientes();
	}

}