package br.com.fuctura.entidades;

import java.io.Serializable;

public class Vendedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int codVendedor;
	private String nome;
	private Loja codLoja;
	
	
	public int getCodVendedor() {
		return codVendedor;
	}
	public void setCodVendedor(int codVendedor) {
		this.codVendedor = codVendedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Loja getCodLoja() {
		return codLoja;
	}
	public void setCodLoja(Loja codLoja) {
		this.codLoja = codLoja;
	}
	
}
