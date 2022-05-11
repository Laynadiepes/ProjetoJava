package projeto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Cliente extends Pessoa {
	protected String mesNiver;
	private double valorDevedor;

	public Cliente() {
	}

	public Cliente(String nomeCompleto, String cpf, String endereco, String uf, String cep, String mesNiver) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.endereco = endereco;
		this.uf = uf;
		this.cep = cep;
		this.mesNiver = mesNiver;
	}
	
	public Cliente(String nomeCompleto, String cpf, String endereco, String uf, String cep, double valorDevedor, String mesNiver) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.endereco = endereco;
		this.uf = uf;
		this.cep = cep;
		this.valorDevedor = valorDevedor;
		this.mesNiver = mesNiver;
	}

// Metodos gets e sets

	protected String getMesNiver() {
		return mesNiver;
	}

	protected void setMesNiver(String mesNiver) {
		this.mesNiver = mesNiver;
	}

	protected double getValorDevedor() {
		return valorDevedor;
	}

	protected void setValorDevedor(double valorDevedor) {
		this.valorDevedor = valorDevedor;
	}

	public void pagar(double valorPago) {

		if (valorPago <= 0) {
			System.out.println("Valor de pagamento incorreto, vc digitou um valor negativo");
		} else {
			this.valorDevedor = this.valorDevedor - valorPago;

		}
	}

	public void somarDevedor(double valorProcedimento) {

		this.setValorDevedor(this.getValorDevedor() + valorProcedimento);

	}

	public static void resumo(String caminho, ArrayList<Cliente> listaC) {
		try {
			FileWriter fw = new FileWriter(caminho);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < listaC.size(); i++) {

				Cliente aux = listaC.get(i);

				bw.write("\nNome Completo: " + aux.getNomeCompleto());
				bw.newLine();
				bw.write("CPF: " + aux.getCpf());
				bw.newLine();
				bw.write("Endereco: " + aux.getEndereco());
				bw.newLine();
				bw.write("UF: " + aux.getUf());
				bw.newLine();
				bw.write("CEP: " + aux.getCep());
				bw.newLine();
				bw.write("Mes de aniversario: " + aux.getMesNiver());
				bw.newLine();

				bw.write("-----------------------------------------\n");

			}
			System.out.println("\nA informacao foi salva no arquivo com sucesso\n");

			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Erro na tentativa de escrever Arquivo: ");
		}
	}

	public static void backup(String caminho, ArrayList<Cliente> listaC) {
		try {
			FileWriter fw = new FileWriter(caminho);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < listaC.size(); i++) {
				Cliente aux = listaC.get(i);
				bw.write(aux.getNomeCompleto() + "#" + aux.getCpf() + "#" + aux.getEndereco() + "#" + aux.getUf() + "#"
						+ aux.getCep() + "#" + aux.getValorDevedor() + "#" + aux.getMesNiver());
				bw.newLine();

			}
			System.out.println("\nBackUp clientes realizado com sucesso");

			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Erro ao realizar backUp de clientes");
		}

	}


}
