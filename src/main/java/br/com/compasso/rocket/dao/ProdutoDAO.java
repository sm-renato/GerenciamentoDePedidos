package br.com.compasso.rocket.dao;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.compasso.rocket.cadastro.ProdutoCadastro;
import br.com.compasso.rocket.models.Produto;

public class ProdutoDAO implements BaseDAO<Set<Produto>> {

	private ObjectMapper mapper = new XmlMapper();
	private ProdutoCadastro produto;

	@Override
	public Set<Produto> desserealiza() throws IOException {
		File file = new File("Produtos.xml");
		this.produto = this.mapper.readValue(file, ProdutoCadastro.class);
		return this.produto.getProdutos();
	}

}