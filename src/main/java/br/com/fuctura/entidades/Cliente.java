package br.com.fuctura.entidades;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int cod_cliente;
	private String nome;
	private String cpf;
	private String telefone;
	private String num_endereco;
	private Endereco cep_endereco;
	
	
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNum_endereco() {
		return num_endereco;
	}
	public void setNum_endereco(String num_endereco) {
		this.num_endereco = num_endereco;
	}
	public Endereco getCep_endereco() {
		return cep_endereco;
	}
	public void setCep_endereco(Endereco cep_endereco) {
		this.cep_endereco = cep_endereco;
	}
}
