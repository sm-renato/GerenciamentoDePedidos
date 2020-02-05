package br.com.compasso.rocket.cadastro;

import java.io.IOException;
import java.util.Scanner;

import br.com.compasso.rocket.dao.BaseDAO;

public interface Cadastro<T> {
	
	default int menuDaOpcao(String funcao, Scanner scan, int voltar) {
		try {
			System.out.println();
			System.out.print("Pressione uma tecla para " + funcao + " ou 0 para voltar ao menu principal: ");
			voltar = Integer.parseInt(scan.nextLine());
			return voltar;
		} catch (Exception e) {
			return -1;
		}
	}

	default <O> void confirmacaoDoCadastro(Object objeto, BaseDAO<O> dao, Cadastro<T> cadastro, String filename, Scanner scan) {
		try {
//			XXX
			System.out.println();
			System.out.println(objeto);
			System.out.print("Pressione uma tecla para confirmar ou 0 para cancelar: ");
			
			int decisao;
			try {
				decisao = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				decisao = 1;
			}
			
			if (decisao != 0) {
				salvar(dao, cadastro, filename);
				System.out.println("Operação realizada com sucesso!");
			} else {
				System.out.println("Operação cancelada!");
			}
		} catch (Exception e) {
		}
	}
	
	default <O> void salvar(BaseDAO<O> dao, Cadastro<T> cadastro, String filename) throws IOException {
		dao.serializa(cadastro, filename);
	}
	
	void cadastra(Scanner scan);
	
}