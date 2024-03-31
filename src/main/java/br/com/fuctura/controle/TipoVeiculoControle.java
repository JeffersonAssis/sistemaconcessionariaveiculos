package br.com.fuctura.controle;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.TipoVeiculoDao;
import br.com.fuctura.entidades.TipoVeiculo;

public class TipoVeiculoControle {
	
	static TipoVeiculoDao tDao = new TipoVeiculoDao();
	final static Scanner scM = new Scanner(System.in);
	
	public void cadastraTipo() {
		TipoVeiculo t = new TipoVeiculo();
		System.out.println("Qual o tipo de veiculo?");
		t.setTipoVeiculo(scM.nextLine());
		tDao.cadastraTipoVeiculo(t);
	}
	
	public List<TipoVeiculo> listaTipo(){
		List<TipoVeiculo> listTipo = tDao.listaTipoVeiculo();	
		for(TipoVeiculo t : listTipo) {
			System.out.println((listTipo.indexOf(t)+1)+" Tipo: "+t.getTipoVeiculo());
		}
		return listTipo;
	}
}
