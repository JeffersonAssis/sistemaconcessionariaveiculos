package br.com.fuctura.controle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.fuctura.dao.VeiculoDao;
import br.com.fuctura.dao.VendedorDao;
import br.com.fuctura.entidades.Loja;
import br.com.fuctura.entidades.Veiculo;
import br.com.fuctura.entidades.Vendedor;

public class VeiculoControle {
	/*
	static VeiculoDao veDao = new VeiculoDao();
	final static Scanner scM = new Scanner(System.in);
	final  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public void cadastra() throws Exception {
		
		LojaControle e = new LojaControle();
		Veiculo v = new Veiculo();
		System.out.print("Placa do Veiculo: ");
		v.setPlaca(scM.next());
		System.out.print("Modelo: ");
		v.setModelo(scM.next());
		System.out.print("Valor do veiculo: ");
		v.setValor(scM.nextFloat());
		System.out.print("Ano do veiculo: ");
		String a = scM.next();
		Date dat = sdf.parse(a);
	    java.sql.Date ano = new java.sql.Date(dat.getTime());
		v.setAno(ano);
		Loja l = e.buscarLoja();
		v.setCodLoja(l);
		
		v = veDao.save(v);

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
	*/
}
