package br.com.fuctura.entidades;

import java.io.Serializable;

public class Loja implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int codLoja;
	private String nomeLoja;
	private String numEndereco;
	private Endereco cep_endereco;
	
	public int getCodLoja() {
		return codLoja;
	}
	public void setCodLoja(int codLoja) {
		this.codLoja = codLoja;
	}
	public String getNomeLoja() {
		return nomeLoja;
	}
	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	public String getNumEndereco() {
		return numEndereco;
	}
	public void setNumEndereco(String numEndereco) {
		this.numEndereco = numEndereco;
	}
	public Endereco getCep_endereco() {
		return cep_endereco;
	}
	public void setCep_endereco(Endereco cep_endereco) {
		this.cep_endereco = cep_endereco;
	}
}
