package br.com.compasso.rocket.cadastro;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.rocket.dao.ProdutoDAO;
import br.com.compasso.rocket.models.Produto;

@JacksonXmlRootElement(localName = "ProdutoCadastro")
public class ProdutoCadastro implements Cadastro<Produto> {

	@JacksonXmlProperty(localName = "produto")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Set<Produto> produtos = new HashSet<Produto>();

	private ProdutoDAO produtoDao = new ProdutoDAO();
	private final String filename = "Produtos.xml";

	@Override
	public void cadastra(Scanner scan) {
		int voltar = 1;

		do {
			voltar = menuDaOpcao("cadastrar um produto", scan, voltar);

			if (voltar != 0) {
				Produto produto = new Produto();
				boolean executa = true;
				
				System.out.println("Cadastro de produto:");
				System.out.print("Digite o código: ");
				try {
					produto.setCodigo(Integer.parseInt(scan.nextLine()));
				} catch (Exception e) {
					produto.setCodigo(-1);
					executa = false;
				}

				try {
					this.produtos = new HashSet<Produto>(produtoDao.desserealiza());
				} catch (IOException e) {
				}

				if (!produtos.add(produto)) {
					System.err.println("Produto já cadastrado!");
					executa = false;
				}

				if (executa) {
					System.out.print("Digite descrição: ");
					produto.setDescricao(scan.nextLine());

					if (produto.getDescricao() != null) {
						System.out.print("Preço: ");
						
						try {
							produto.setPreco(Double.parseDouble(scan.nextLine()));
						} catch (Exception e) {
							produto.setPreco(0);
						}
						if (produto.getPreco() > 0) {
							System.out.print("Quantidade: ");
							
							try {
								produto.setQuantidade(Integer.parseInt(scan.nextLine()));
							} catch (Exception e) {
								produto.setQuantidade(0);
							}

							if (produto.getQuantidade() > 0) {
								confirmacaoDoCadastro(produto, produtoDao, this, filename, scan);
							}
						}
					}
				}
			}
			
		} while (voltar != 0);
		
	}

	public Set<Produto> getProdutos() throws IOException {
		return Collections.unmodifiableSet(produtos);
	}
}