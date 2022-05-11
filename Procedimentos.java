package projeto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Procedimentos {

	protected int idProcedimento;
	protected String nomeProcedimento;
	protected double valorProcedimento;

	public Procedimentos() {

	}

	public Procedimentos(int idProcedimento, String nomeProcedimento, double valorProcedimento) {
		this.idProcedimento = idProcedimento;
		this.nomeProcedimento = nomeProcedimento;
		this.valorProcedimento = valorProcedimento;
	}

// Metodos gets e sets
	protected int getIdProcedimento() {
		return idProcedimento;
	}

	protected void setIdProcedimento(int idProcedimento) {
		this.idProcedimento = idProcedimento;
	}

	protected String getNomeProcedimento() {
		return nomeProcedimento;
	}

	protected void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}

	protected double getValorProcedimento() {
		return valorProcedimento;
	}

	protected void setValorProcedimento(double valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}

	public void resumoProcedimento() {
		System.out.println("Id do Procedimento: " + getIdProcedimento());
		System.out.println("Nome do Procedimento: " + getNomeProcedimento());
		System.out.println("Valor do Procedimento: " + getValorProcedimento());
	}

	public static void resumo(String caminho, ArrayList<Procedimentos> listaS) {
		try {
			FileWriter fw = new FileWriter(caminho);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < listaS.size(); i++) {

				Procedimentos aux = listaS.get(i);

				bw.write("\nNome do Procedimento: " + aux.getNomeProcedimento());
				bw.newLine();
				bw.write("Valor do Procedimento: " + aux.getValorProcedimento());
				bw.newLine();
				bw.write("ID do Procedimento: " + aux.getIdProcedimento());
				bw.newLine();

				bw.write("-----------------------------------------");

			}
			System.out.println("\nA informacao foi salva no arquivo com sucesso\n");

			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Erro na tentativa de escrever Arquivo: ");
		}
	}

	public static void backup(String caminho, ArrayList<Procedimentos> listaS) {
		try {
			FileWriter fw = new FileWriter(caminho);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < listaS.size(); i++) {
				Procedimentos aux = listaS.get(i);
				bw.write(aux.getIdProcedimento() + "#" + aux.getNomeProcedimento() + "#" + aux.getValorProcedimento());
				bw.newLine();
			}
			System.out.println("\nBackUp procedimentos realizado com sucesso");

			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Erro ao realizar backUp de procedimentos");
		}

	}

}
