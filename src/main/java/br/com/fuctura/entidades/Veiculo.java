package br.com.fuctura.entidades;

import java.io.Serializable;
import java.util.Date;

public class Veiculo implements Serializable {


	private static final long serialVersionUID = 1L;
	private int codVeiculo;
	private String placa;
	private String modelo;
	private Date ano;
	private float valor;
	private TipoVeiculo tipoVeiculo;
	private Loja codLoja;

	public int getCodVeiculo() {
		return codVeiculo;
	}
	public void setCodVeiculo(int codVeiculo) {
		this.codVeiculo = codVeiculo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Loja getCodLoja() {
		return codLoja;
	}
	public void setCodLoja(Loja codLoja) {
		this.codLoja = codLoja;
	}
	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Date getAno() {
		return ano;
	}
	public void setAno(Date ano) {
		this.ano = ano;
	}
	
}
