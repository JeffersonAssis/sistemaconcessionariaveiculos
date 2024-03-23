package br.com.fuctura.controle;

import java.util.Scanner;

import br.com.fuctura.dao.VendedorDao;
import br.com.fuctura.entidades.Loja;
import br.com.fuctura.entidades.Vendedor;

public class VendedorControle {

	static VendedorDao vDao = new VendedorDao();
	final static Scanner scM = new Scanner(System.in);

	public void cadastra() throws Exception {
		LojaControle e = new LojaControle();
		Vendedor c = new Vendedor();
		System.out.print("Nome: ");
		c.setNome(scM.next());
		Loja l = e.buscarLoja();
		c.setCodLoja(l);
		
		c = vDao.save(c);

	}

	public void buscar() throws Exception{

		Vendedor c = new Vendedor();
		String nome;

		System.out.println("Informe o nome do Vendedor: ");
		nome = scM.next();

		c = vDao.consultarNome(nome);
		if(c.getNome()!=null) {
		System.out.println("Nome: " + c.getNome() + " Codigo - " + c.getCodVendedor() + "\nLoja: "+c.getCodLoja().getNomeLoja());
		}else {
			System.out.println("Nenhum vendedor foi encontrado!");
		}
		

	}

	public void excluir() {
		System.out.println("Informe o nome do vendedor: ");
		String nome = scM.next();
		vDao.excluirVendedor(nome);
	}
	
	public void atualizar() throws Exception {
		Vendedor c = new Vendedor();
		LojaControle lc = new LojaControle();
		System.out.println("Informe o nome do vendedor: ");
		String nome = scM.next();
		c = vDao.consultarNome(nome);

		System.out.println("Nome: " + c.getNome() + "  - Loja: " + c.getCodLoja().getNomeLoja());
		
		System.out.print("Nome: ");
		c.setNome(scM.next());
		Loja loja = lc.buscarLoja();
		c.setCodLoja(loja);
		

	 vDao.atualizarVendedor(nome,c);
	}
}
