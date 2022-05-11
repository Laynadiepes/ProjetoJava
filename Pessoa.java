package projeto;

import java.util.ArrayList;

//import java.io.BufferedReader;
//import java.io.FileReader;

public class Pessoa {
	
	protected String nomeCompleto;
	protected String endereco;
	protected String uf;
	protected String cpf;
	protected String cep;
	ArrayList<Procedimentos> listaS = new ArrayList<Procedimentos>();

	public Pessoa() {
	}

	// Metodos gets e sets
	
	protected String getNomeCompleto() {
		return nomeCompleto;
	}

	protected void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	} 
	
	protected String getEndereco(){
		return endereco;
	}
	
	protected void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	protected String getUf(){
		return uf;
	}
	
	protected void setUf(String uf) {
		this.uf = uf;
	}
	
	protected String getCep(){
		return cep;
	}
	
	protected void setCep(String cep) {
		this.cep = cep;
	}
	
	protected String getCpf(){
		return cpf;
	}
	
	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public void listarProcedimentos() {
		try {
		for(int i = 0; i < listaS.size(); i++) {
			Procedimentos aux = listaS.get(i);
			aux.resumoProcedimento();
		}
		}catch (Exception e) {
			System.out.println("Erro ao listar procedimentos ");
		}
		
	}
	
}

