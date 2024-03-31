package br.com.fuctura.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.LojaDao;
import br.com.fuctura.entidades.Endereco;
import br.com.fuctura.entidades.Loja;

public class LojaControle {
	
	static LojaDao lDao = new LojaDao(); 
	final static Scanner scM = new Scanner(System.in);

	public void cadastra() throws Exception {
		EnderecoControle e = new EnderecoControle();
		Loja c = new Loja();
		System.out.println("Cadastro de Loja");
		System.out.print("Nome da Loja: ");
		c.setNomeLoja(scM.next());
		Endereco end = e.buscar();
		c.setCep_endereco(end);
		System.out.print("Nº da residência: ");
		c.setNumEndereco(scM.next());
		c = lDao.save(c);

	}
	
	public List<Loja> listarLojas() {
		List<Loja> listLoja = new ArrayList<Loja>();
		System.out.println("Listando Loja");
		
		listLoja = lDao.listarTodasLoja();
		System.out.println("Listas de lojas: ");
		System.out.println("###############################################################");
		for(Loja c : listLoja) {
		System.out.println("Nome: " + c.getNomeLoja() +" Codigo Loja: "+c.getCodLoja()
				+ "\nEndereco: " + c.getCep_endereco().getLogradouro() + " - " + c.getNumEndereco() + "\nBairro: "
				+ c.getCep_endereco().getBairro() + " - " + c.getCep_endereco().getLocalidade() + "/"
				+ c.getCep_endereco().getUf());
		System.out.println("###############################################################");

		}
		return listLoja;
	}
	
	public List<Loja> listarLojasVeiculo() {
		List<Loja> listLoja = new ArrayList<Loja>();
		System.out.println("Listando Loja");
		
		listLoja = lDao.listarTodasLoja();
		System.out.println("Listas de lojas: ");
		for(Loja c : listLoja) {
		System.out.println((listLoja.indexOf(c)+1) +" - Nome: " + c.getNomeLoja());
		}
		return listLoja;
	}
	
	public Loja buscarLoja() {
		Loja c = new Loja();
		String nome;
		System.out.println("Informe o nome da Loja: ");
		nome = scM.next();
		c = lDao.buscarLoja(nome);
		System.out.println("###############################################################");
		System.out.println("Nome: " + c.getNomeLoja() +" Codigo Loja: "+c.getCodLoja()
				+ "\nEndereco: " + c.getCep_endereco().getLogradouro() + " - " + c.getNumEndereco() + "\nBairro: "
				+ c.getCep_endereco().getBairro() + " - " + c.getCep_endereco().getLocalidade() + "/"
				+ c.getCep_endereco().getUf());
		System.out.println("###############################################################");
		
		return c;
	}
	
	public void excluir() {
		String nome;
		System.out.println("Informe o nome da loja: ");
		nome = scM.next();
		lDao.excluirLoja(nome);
	}
	
	public void atualizar() throws Exception {
		EnderecoControle e = new EnderecoControle();
		Loja c = new Loja();
		System.out.print("Nome da Loja: ");
		String nome = scM.next();
		c = lDao.buscarLoja(nome);
		System.out.println("Nome: " + c.getNomeLoja() +" Codigo - Loja: " +c.getCodLoja()
				+ "\nEndereco: " + c.getCep_endereco().getLogradouro() + " - " + c.getNumEndereco() + "\nBairro: "
				+ c.getCep_endereco().getBairro() + " - " + c.getCep_endereco().getLocalidade() + "/"
				+ c.getCep_endereco().getUf());
		
		System.out.print("Nome da Loja: ");
		c.setNomeLoja(scM.next());
		Endereco end = e.buscar();
		c.setCep_endereco(end);
		System.out.print("Nº da residência: ");
		c.setNumEndereco(scM.next());

	 lDao.atualizarLoja(nome,c);
	}
}
