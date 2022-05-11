package projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
	static Procedimentos auxReal;
	static Cliente aux2Real;
	static Profissional aux3Real;
	static int idProcedimento;
	static String cepFormat;
	static String cpfFormat;

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int op;

		ArrayList<Cliente> listaC = new ArrayList<Cliente>();
		ArrayList<Profissional> listaP = new ArrayList<Profissional>();
		ArrayList<Procedimentos> listaS = new ArrayList<Procedimentos>();

		System.out.println("\nNão esqueca de fazer o upload dos seus dados antes de iniciar\n");
		do {
			exibirMenu();
			op = Integer.parseInt(scan.nextLine());

			switch (op) {

			case 1: {
				String senha;
				String nomeCompleto;
				String cpf;
				String usuario;
				String cep;
				String uf;

				try {
					System.out.println("\n-----Cadastro de Profissional-----\n");

					do {
						System.out.println("Digite o Nome Completo do Profissional:");
						nomeCompleto = scan.nextLine();
					} while (verificaEspaco(nomeCompleto) == false);

					do {
						System.out.println("Digite o CPF do Profissional :");
						cpf = scan.nextLine();
					} while (verificaCPF(cpf) == false);

					System.out.println("Digite o endereco completo do Profissional:");
					String endereco = scan.nextLine();

					do {
						System.out.println("Digite o uf completo do Profissional:");
						uf = scan.nextLine();
					} while (verificaUF(uf) == false);

					do {
						System.out.println("Digite o CEP do Profissional:");
						cep = scan.nextLine();
					} while (verificaCEP(cep) == false);

					System.out.println("Digite a Especialidade do Profissional:");
					String especialidade = scan.nextLine();

					System.out.println("\n-----Cadastro Login e Senha-----\n");

					do {
						System.out.println("Escolha um Nome de Usuario para o Profissional:");
						usuario = scan.nextLine();
					} while (verificaEspaco(usuario) == true);

					do {
						System.out.println("Digite uma Senha para o Profissional:");
						senha = scan.nextLine();
					} while (verificaSenha(senha) == false);

					Profissional prof = new Profissional(nomeCompleto, cpfFormat, endereco, uf, cepFormat, usuario,
							senha, especialidade);

					if (listaP.add(prof)) {
						System.out.println("\nProfissional Cadastrado com sucesso.\n");

					} else {
						System.out.println("\nErro ao cadastrar profissional.\n");
					}
				} catch (Exception e) {
					System.out.println("\nErro ao cadastrar profissional.");
				}

				break;
			}

			case 2: {

				String nomeCompleto;
				String cpf;
				String uf;
				String cep;
				String mesNiver;

				if (fazerLogin(listaP) == false) {
					break;
				} else {

					try {
						System.out.println("\n-----Cadastro de Cliente-----\n");

						do {
							System.out.println("Digite o Nome Completo do Cliente:");
							nomeCompleto = scan.nextLine();
						} while (verificaEspaco(nomeCompleto) == false);

						do {
							System.out.println("Digite o CPF do Cliente:");
							cpf = scan.nextLine();
						} while (verificaCPF(cpf) == false);

						System.out.println("Digite o endereco completo do Cliente:");
						String endereco = scan.nextLine();

						do {
							System.out.println("Digite o uf completo do Cliente:");
							uf = scan.nextLine();
						} while (verificaUF(uf) == false);

						do {
							System.out.println("Digite o CEP do Cliente: ");
							cep = scan.nextLine();
						} while (verificaCEP(cep) == false);

						do {
							System.out.println("Digite o mes do aniversario do cliente:");
							mesNiver = scan.nextLine();
						} while (verificaMes(mesNiver) == false);

						Cliente cli = new Cliente(nomeCompleto, cpfFormat, endereco, uf, cepFormat, mesNiver);

						if (listaC.add(cli)) {
							System.out.println("\nCliente Cadastrado com sucesso.\n");
						} else {
							System.out.println("\nErro ao cadastrar Cliente.\n");
						}
					} catch (Exception e) {
						System.out.println("\nErro ao cadastrar cliente.");
					}

					break;

				}

			}

			case 3: {

				if (fazerLogin(listaP) == false) {
					break;
				} else {
					try {

						ultimoId(listaS);
						System.out.println("\n-----Cadastro de Procedimento-----\n");

						System.out.println("Digite o nome do procedimento:");
						String nomeProcedimento = scan.nextLine();

						System.out.println("Digite o valor do procedimento:");
						double valorProcedimento = Double.parseDouble(scan.nextLine());

						Procedimentos ser = new Procedimentos(idProcedimento, nomeProcedimento, valorProcedimento);

						if (listaS.add(ser)) {
							System.out.println("\nProcedimento Cadastrado com sucesso.\n");
							idProcedimento++;
						} else {
							System.out.println("\nErro ao cadastrar procedimento.\n");
						}
					} catch (Exception e) {
						System.out.println("\nErro ao cadastrar procedimento.");
					}

					break;

				}

			}

			case 4: {
				String caminho = "/users/laynadiepes/documents/ResumoProfissionais.txt";
				verificarArquivo(caminho);
				Profissional.resumo(caminho, listaP);
				break;
			}
			case 5: {
				String caminho = "/users/laynadiepes/documents/ResumoClientes.txt";
				verificarArquivo(caminho);
				Cliente.resumo(caminho, listaC);
				break;
			}
			case 6: {
				String caminho = "/users/laynadiepes/documents/ResumoProcedimentos.txt";
				verificarArquivo(caminho);
				Procedimentos.resumo(caminho, listaS);
				break;
			}

			case 7: {
				String dado;
				String cpfCliente, cpfProfissional;
				if (fazerLogin(listaP) == false) {
					break;
				} else {
					try {
						do {
							System.out.println("Digite o Id ou Nome do procedimento que ira realizar: ");
							dado = scan.nextLine();
						} while (!verificaId(dado, listaS) && !verificaNomeProc(dado, listaS));

						do {
							System.out.println("Digite o CPF do Cliente que ira realizar o procedimento?");
							cpfCliente = scan.nextLine();
							verificaCPF(cpfCliente);
						} while (!verificaCpfCli(cpfFormat, listaC));

						aux2Real.listaS.add(auxReal);
						System.out.println("Cadastro de Realização de procedimento realizado com sucesso!\n");
						System.out.println("O procedimento Realizado custou " + auxReal.getValorProcedimento()
								+ "\n Como deseja Prosseguir? \n"
								+ " 1- Realizar Pagamento \n 2- Registrar valor e Pagar no futuro");
						int escolha = Integer.parseInt(scan.nextLine());

						switch (escolha) {

						case 1: {
							aux2Real.somarDevedor(auxReal.getValorProcedimento());
							System.out.println(
									"\nVoce escolheu Realizar Pagamento\nValor Pago: " + aux2Real.getValorDevedor());
							aux2Real.pagar(aux2Real.getValorDevedor());
							System.out.println("Pagamento Realizado com sucesso!");
							break;
						}
						case 2: {
							aux2Real.somarDevedor(auxReal.getValorProcedimento());
							System.out.println("Voce deve atualmente: " + aux2Real.getValorDevedor());
							break;
						}
						}

						do {
							System.out.println("\nDigite o CPF do Profissional que realizou o procedimento?");
							cpfProfissional = scan.nextLine();
							verificaCPF(cpfProfissional);
						} while (!verificaCpfProf(cpfFormat, listaP));
						aux3Real.listaS.add(auxReal);
						aux3Real.somarValTotal(auxReal.getValorProcedimento());

					} catch (Exception e) {
						System.out.println("\nErro ao cadastrar realizacao de procedimento");
					}
				}

				break;

			}

			case 8:

			{

				try {
					System.out.println("\nDigite o CPF do cliente para visualização de historico");
					String cpf = scan.nextLine();
					verificaCPF(cpf);

					for (int j = 0; j < listaC.size(); j++) {

						Cliente aux = listaC.get(j);

						if (aux.getCpf().equals(cpfFormat)) {

							System.out.println("\nNome Completo: " + aux.getNomeCompleto());
							System.out.println("\nCPF: " + aux.getCpf());

							System.out.println("\n---------------------------------------");

							aux.listarProcedimentos();

						}
					}
				} catch (Exception e) {
					System.out.println("Erro ao encontrar CPF ");
				}
				break;

			}

			case 9: {

				try {

					System.out.println("\n Digite o CPF do profissional para visualização de historico");
					String cpf = scan.nextLine();
					verificaCPF(cpf);

					for (int j = 0; j < listaP.size(); j++) {

						Profissional aux = listaP.get(j);

						if (aux.getCpf().equals(cpfFormat)) {

							System.out.println("\nNome Completo: " + aux.getNomeCompleto());
							System.out.println("\nCPF: " + aux.getCpf());
							System.out.println("\nValor Total de Procedimentos Realizados: " + aux.getValorTotal());
							System.out.println("---------------------------------------");

							aux.listarProcedimentos();

						}
					}
				} catch (Exception e) {
					System.out.println("Erro ao encontrar CPF ");
				}
				break;

			}

			case 10: {

				String caminho = "/users/laynadiepes/documents/BackUpProf.txt";
				String caminho2 = "/users/laynadiepes/documents/BackUpCli.txt";
				String caminho3 = "/users/laynadiepes/documents/BackUpProc.txt";

				verificarArquivo(caminho);
				verificarArquivo(caminho2);
				verificarArquivo(caminho3);

				Profissional.backup(caminho, listaP);
				Cliente.backup(caminho2, listaC);
				Procedimentos.backup(caminho3, listaS);

				break;
			}

			case 11:

			{
				String caminho = "/users/laynadiepes/documents/BackUpProf.txt";
				String caminho2 = "/users/laynadiepes/documents/BackUpCli.txt";
				String caminho3 = "/users/laynadiepes/documents/BackUpProc.txt";

				try {
					BufferedReader br = new BufferedReader(new FileReader(caminho));
					while (br.ready()) {
						String linha = br.readLine();
						String vet[] = linha.split("#");
						String nomeCompleto = vet[0];
						String cpf = vet[1];
						String endereco = vet[2];
						String uf = vet[3];
						String cep = vet[4];
						String usuario = vet[5];
						String senha = vet[6];
						String especialidade = vet[7];
						Double valorTotal = Double.parseDouble(vet[8]);

						Profissional prof = new Profissional(nomeCompleto, cpf, endereco, uf, cep, usuario, senha,
								especialidade, valorTotal);

						listaP.add(prof);
					}
					System.out.println("\nUpload de profissionais realizado com sucesso");
					br.close();
				} catch (Exception e) {
					System.out.println("\nErro ao realizar upload de profissionais");
				}

				try {
					BufferedReader br = new BufferedReader(new FileReader(caminho2));
					while (br.ready()) {
						String linha = br.readLine();
						String vet[] = linha.split("#");
						String nomeCompleto = vet[0];
						String cpf = vet[1];
						String endereco = vet[2];
						String uf = vet[3];
						String cep = vet[4];
						Double valorDevedor = Double.parseDouble(vet[5]);
						String mesNiver = vet[6];
						Cliente cli = new Cliente(nomeCompleto, cpf, endereco, uf, cep, valorDevedor, mesNiver);

						listaC.add(cli);

					}
					System.out.println("\nUpload de clientes realizado com sucesso");
					br.close();
				} catch (Exception e) {
					System.out.println("\nErro ao realizar upload de clientes ");
				}
				try {
					BufferedReader br = new BufferedReader(new FileReader(caminho3));
					while (br.ready()) {
						String linha = br.readLine();
						String vet[] = linha.split("#");
						int id = Integer.parseInt(vet[0]);
						String nome = vet[1];
						double valor = Double.parseDouble(vet[2]);
						Procedimentos proc = new Procedimentos(id, nome, valor);

						listaS.add(proc);

					}
					System.out.println("\nUpload de procedimentos realizado com sucesso");
					br.close();
				} catch (Exception e) {
					System.out.println("\nErro ao realizar upload de procedimentos ");
				}

				break;

			}
			}
		} while (op != 12);

		scan.close();

	}

	public static void exibirMenu() {
		System.out.println("\n--------------------Menu-------------------- ");
		System.out.println("1 - Cadastrar Profissional ");
		System.out.println("2 - Cadastrar Cliente ");
		System.out.println("3 - Cadastrar Procedimentos ");
		System.out.println("4 - Obter Resumo Profissionais ");
		System.out.println("5 - Obter Resumo Clientes ");
		System.out.println("6 - Obter Resumo Procedimentos ");
		System.out.println("7 - Cadastrar Realizacao de Procedimento ");
		System.out.println("8 - Visualizar Historico de Cliente");
		System.out.println("9 - Visualizar Historico do Profissional");
		System.out.println("10 - Fazer backup de dados");
		System.out.println("11 - Fazer upload de dados");
		System.out.println("-------------------------------------------- ");
		System.out.println("\nEscolha a opcao desejada: ");

	}

	public static boolean fazerLogin(ArrayList<Profissional> listaP) {
		Scanner scaner = new Scanner(System.in);

		System.out.println("\nDigite seu usuario e senha\n");
		System.out.println("Usuario: ");
		String encontraUser = scaner.nextLine();
		int i = 0;

		while (i < listaP.size()) {

			Profissional aux = listaP.get(i);

			if (aux.getUsuario().equals(encontraUser)) {
				System.out.println("Digite a senha do usuario " + aux.getUsuario());
				String encontraSenha = scaner.nextLine();
				if (aux.getSenha().equals(encontraSenha)) {
					System.out.println("\nUsuario e senha conferem!");
					return true;
				} else {
					System.out.println("\nSenha incorreta");
					return false;
				}
			} else {
				i++;
			}
			scaner.close();
			;

		}
		System.out.println("\n Usuario " + encontraUser + " nao encontrado");
		scaner.close();
		return false;
	}

	public static void verificarArquivo(String caminho) throws Exception {
		File arquivo = new File(caminho);
		if (arquivo.exists()) {
			System.out.println("\nO arquivo foi localizado com sucesso");
		} else {
			if (arquivo.createNewFile()) {
				System.out.println("\nO arquivo foi criado com sucesso");
			} else {
				System.out.println("\nErro ao criar o arquivo");
			}
		}
	}

	public static boolean verificaSenha(String senha) {

		try {

			if (senha.length() < 6) {
				System.out.println("\nA senha deve ter:" + "\n- Pelo menos uma letra maiúscula "
						+ "\n- Pelo menos uma letra minúscula " + "\n- Pelo menos um número "
						+ "\n- Pelo menos 6 caractéres");
				return false;

			}

			boolean achouNumero = false;
			boolean achouMaiuscula = false;
			boolean achouMinuscula = false;
			for (char c : senha.toCharArray()) {
				if (c >= '0' && c <= '9') {
					achouNumero = true;
				} else if (c >= 'A' && c <= 'Z') {
					achouMaiuscula = true;
				} else if (c >= 'a' && c <= 'z') {
					achouMinuscula = true;
				}
			}
			if (achouNumero && achouMaiuscula && achouMinuscula) {
				return true;
			} else {
				System.out.println("\nA senha deve ter:" + "\n- Pelo menos uma letra maiúscula "
						+ "\n- Pelo menos uma letra minúscula " + "\n- Pelo menos um número "
						+ "\n- Pelo menos 6 caractéres");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Erro ao verificar senha");
			return false;
		}

	}

	public static boolean verificaEspaco(String dado) {
		if (dado.contains(" ")) {
			return true;
		} else
			return false;

	}

	public static boolean verificaCPF(String cpf) {

		cpf = limpaGeral(cpf);

		if (cpf.length() == 14) {
			cpf = cpf.replace(".", "");
			cpf = cpf.replace(".", "");
			cpf = cpf.replace("-", "");
		}
		if (cpf.length() == 11 && verificaNum(cpf)) {
			cpfFormat = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
					+ cpf.substring(9);
			return true;
		} else {
			System.out.println("\n CPF Inválido");
			return false;
		}

	}

	public static boolean verificaCEP(String cep) {

		cep = limpaGeral(cep);

		if (cep.length() == 9) {
			cep = cep.replace("-", "");
		}
		if (cep.length() == 8 && verificaNum(cep)) {
			cepFormat = cep.substring(0, 5) + "-" + cep.substring(5);
			return true;
		} else {
			System.out.println("\n CEP Inválido");
			return false;
		}
	}

	public static boolean verificaUF(String dado) {

		String uf = dado.trim().toUpperCase();

		String todos[] = { "AL", "AP", "AC", "TO", "SE", "SP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS",
				"MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC" };

		for (int i = 0; i <= 26; i++) {

			if (uf.equals(todos[i])) {
				return true;
			}

		}
		System.out.println("\n UF Inválido");
		return false;
	}

	public static boolean verificaMes(String dado) {

		String mesNiver = dado.trim().toLowerCase();

		String todos[] = { "janeiro", "fevereiro", "março", "abril", "maio", "junho ", "julho", "agosto", "setembro",
				"outubro", "novembro", "dezembro" };

		for (int i = 0; i <= 12; i++) {

			if (mesNiver.equals(todos[i])) {
				return true;
			}

		}
		System.out.println("\n Mês Inválido");
		return false;
	}

	public static boolean verificaId(String id, ArrayList<Procedimentos> listaS) {

		for (int i = 0; i < listaS.size(); i++) {

			Procedimentos aux = listaS.get(i);

			if ((Integer.toString(aux.getIdProcedimento())).equals(id)) {
				auxReal = aux;
				return true;
			}
		}
		return false;
	}

	public static boolean verificaNomeProc(String nome, ArrayList<Procedimentos> listaS) {

		nome = limpaGeral(nome);

		for (int i = 0; i < listaS.size(); i++) {

			Procedimentos aux = listaS.get(i);

			if (aux.getNomeProcedimento().equalsIgnoreCase(nome)) {
				auxReal = aux;
				return true;
			}
		}
		return false;
	}

	public static boolean verificaCpfCli(String cpf, ArrayList<Cliente> listaC) {

		for (int i = 0; i < listaC.size(); i++) {

			Cliente aux = listaC.get(i);

			if (aux.getCpf().equals(cpf)) {
				aux2Real = aux;
				return true;
			}
		}
		System.out.println("\n CPF não encontrado");
		return false;
	}

	public static boolean verificaCpfProf(String cpfProfissional, ArrayList<Profissional> listaP) {

		for (int i = 0; i < listaP.size(); i++) {

			Profissional aux = listaP.get(i);

			if (aux.getCpf().equals(cpfProfissional)) {
				aux3Real = aux;
				return true;
			}
		}

		System.out.println("\n CPF não encontrado");
		return false;
	}

	public static void ultimoId(ArrayList<Procedimentos> listaS) {

		String caminho = "/users/laynadiepes/documents/BackUpProC.txt";

		try {
			BufferedReader br = new BufferedReader(new FileReader(caminho));
			while (br.ready()) {
				String linha = br.readLine();
				String vet[] = linha.split("#");
				idProcedimento = Integer.parseInt(vet[0]) + 1;

			}
			br.close();
		} catch (Exception e) {
			System.out.println("\nErro ao encontrar ultimo ID ");
		}
	}

	public static String limpaGeral(String dado) {

		dado = dado.trim();

		while (dado.contains("  ")) {
			dado = dado.replace("  ", " ");
		}
		return dado;
	}

	public static boolean verificaNum(String dado) {

		if (dado.matches("[0-9]*")) {
			return true;
		} else {
			return false;
		}
	}

}
