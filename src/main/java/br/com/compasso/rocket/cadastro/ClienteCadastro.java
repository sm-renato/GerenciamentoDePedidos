package br.com.compasso.rocket.cadastro;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.rocket.dao.ClienteDAO;
import br.com.compasso.rocket.models.Cliente;
import br.com.compasso.rocket.services.Documentos;

@JacksonXmlRootElement(localName = "ClienteCadastro")
public class ClienteCadastro implements Cadastro<Cliente> {

	@JacksonXmlProperty(localName = "cliente")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Set<Cliente> clientes = new HashSet<Cliente>();

	private ClienteDAO clienteDao = new ClienteDAO();
	private Documentos lidaDoc = new Documentos();
	private final String filename = "Clientes.xml";

	@Override
	public void cadastra(Scanner scan) {
		int voltar = 1;
		
		do {
			voltar = menuDaOpcao("cadastrar um cliente", scan, voltar);

			if (voltar != 0) {
				Cliente cliente = new Cliente();
				boolean executa = true;
				
				System.out.println("Cadastro de cliente:");
				System.out.print("Digite o CPF: ");
				cliente.setCpf(scan.nextLine());
				
				if (!lidaDoc.validaCpf(cliente.getCpf())) {
					System.err.println("CPF inválido!");
					executa = false;
				}
				cliente.setCpf(lidaDoc.formataCpf(cliente.getCpf()));
				
				try {
					this.clientes = new HashSet<Cliente>(clienteDao.desserealiza());
				} catch (IOException e) {
				}

				if (!clientes.add(cliente)) {
					System.err.println("Cliente já cadastrado!");
					executa = false;
				}

				if (executa) {
					System.out.print("Digite o nome: ");
					cliente.setNome(scan.nextLine());
					
					if (cliente.getNome() != null) {
						confirmacaoDoCadastro(cliente, clienteDao, this, filename, scan);
					}
				}
			}
		} while (voltar != 0);
	}

	public Set<Cliente> getClientes() throws IOException {
		return Collections.unmodifiableSet(clientes);
	}
}
