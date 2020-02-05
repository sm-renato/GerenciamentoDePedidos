package br.com.compasso.rocket.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.compasso.rocket.cadastro.Cadastro;
import br.com.compasso.rocket.cadastro.ClienteCadastro;
import br.com.compasso.rocket.cadastro.ProdutoCadastro;

public class App {
	private static Scanner scan = new Scanner(System.in);
	private static boolean running = true;
	private static int opcao = 1;

	public static void main(String[] args) throws Exception {

		while (running) {

			PrintMenu(opcao);

			try {
				opcao = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				opcao = -1;
			}

			switch (opcao) {
			case 1:
//				TODO VerificaEstoque();
				System.err.println("Operação ainda não implementada!");
				break;

			case 2:
//				cadastrar(new PedidoCadastro());
				System.err.println("Operação ainda não implementada!");
				break;

			case 3:
				cadastrar(new ProdutoCadastro());
				break;

			case 4:
				cadastrar(new ClienteCadastro());
				break;

			case 5:
				running = false;
				System.out.println("Até mais!");
				break;

			default:
				System.err.print("Código inválido, tente novamente: ");
				break;
			}
		}
		scan.close();
	}

	private static void PrintMenu(int opcao) {
		if (opcao > 0 && opcao < 6) {
			System.out.println("Selecione a operação desejada:");
			System.out.println(" 1 - Verificar Estoque");
			System.out.println(" 2 - Realizar Pedido");
			System.out.println(" 3 - Cadastrar Produto");
			System.out.println(" 4 - Cadastrar Cliente");
			System.out.println(" 5 - Sair");
			System.out.println("--------------------------------------");
			System.out.print("Digite aqui o código correspondente: ");
		}
	}

	private static <A> void cadastrar(Cadastro<A> cadastro) throws IOException {
		cadastro.cadastra(scan);
	}
}