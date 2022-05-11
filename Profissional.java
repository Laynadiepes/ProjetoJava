package projeto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Profissional extends Pessoa {
	protected String usuario;
	protected String senha;
	protected String especialidade;
	protected double valorTotal;

	public Profissional() {
	}

	public Profissional(String nomeCompleto, String cpf, String endereco, String uf, String cep, String usuario,
			String senha, String especialidade) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.endereco = endereco;
		this.uf = uf;
		this.cep = cep;
		this.usuario = usuario;
		this.senha = senha;
		this.especialidade = especialidade;

	}
	
	public Profissional(String nomeCompleto, String cpf, String endereco, String uf, String cep, String usuario,
			String senha, String especialidade, double valorTotal) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.endereco = endereco;
		this.uf = uf;
		this.cep = cep;
		this.usuario = usuario;
		this.senha = senha;
		this.especialidade = especialidade;
		this.valorTotal =valorTotal;

	}

	// Metodos gets e sets

	protected String getUsuario() {
		return usuario;
	}

	protected void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	protected String getSenha() {
		return senha;
	}

	protected void setSenha(String especialidade) {
		this.especialidade = especialidade;
	}

	protected String getEspecialidade() {
		return especialidade;
	}

	protected void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	protected double getValorTotal() {
		return valorTotal;
	}

	protected void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void somarValTotal(double valorProcedimento) {

		this.setValorTotal(this.getValorTotal() + valorProcedimento);

	}

	public static void resumo(String caminho, ArrayList<Profissional> listaP) {
		try {

			FileWriter fw = new FileWriter(caminho);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < listaP.size(); i++) {

				Profissional aux = listaP.get(i);
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
				bw.write("Especialidade: " + aux.getEspecialidade());
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

	public static void backup(String caminho, ArrayList<Profissional> listaP) {
		try {
			FileWriter fw = new FileWriter(caminho);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < listaP.size(); i++) {
				Profissional aux = listaP.get(i);
				bw.write(aux.getNomeCompleto() + "#" + aux.getCpf() + "#" + aux.getEndereco() + "#" + aux.getUf() + "#"
						+ aux.getCep() + "#" + aux.getUsuario() + "#" + aux.getSenha() + "#" + aux.getEspecialidade()+ "#" + aux.getValorTotal());

				bw.newLine();
			}
			System.out.println("\nBackUp profissionais realizado com sucesso");

			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Erro ao realizar backUp de profissionais");
		}

	}


}
