package br.com.fuctura.controle;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.VeiculoDao;
import br.com.fuctura.entidades.Loja;
import br.com.fuctura.entidades.TipoVeiculo;
import br.com.fuctura.entidades.Veiculo;

public class VeiculoControle {

	static VeiculoDao veDao = new VeiculoDao();
	final static Scanner scM = new Scanner(System.in);
	final  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public void cadastra() throws Exception {
		
		LojaControle e = new LojaControle();
		TipoVeiculoControle t = new TipoVeiculoControle();
		int tveiculo = 0;
		
		Veiculo v = new Veiculo();
		System.out.print("Placa do Veiculo: ");
		v.setPlaca(scM.next());
		System.out.print("Modelo: ");
		v.setModelo(scM.next());
		System.out.print("Valor do veiculo: ");
		v.setValor(scM.nextFloat());
		System.out.print("Ano do veiculo: ");
		v.setAno(scM.nextInt());
		List<Loja> f =  e.listarLojasVeiculo();
		System.out.println("Qual loja o veiculo está?");
		tveiculo = scM.nextInt();
		Loja l = f.get(tveiculo-1);
		v.setCodLoja(l);
		List<TipoVeiculo> g = t.listaTipo();
		System.out.println("Qual o tipo de veiculo?");
		tveiculo = scM.nextInt();
		TipoVeiculo tV = g.get(tveiculo-1);
		v.setTipoVeiculo(tV);
		
		 veDao.save(v);
	}
	
	public void buscar() throws Exception{

		Veiculo v = new Veiculo();
		String placa;

		System.out.println("Informe a placa do veiculo: ");
		placa = scM.next();

		v = veDao.consultarPlaca(placa.toUpperCase());
		if(v.getPlaca()!=null) {
		System.out.println("Placa: " + v.getPlaca() + " Categoria: " + v.getTipoVeiculo().getTipoVeiculo()
				+ "\nAno: " +v.getAno() +" Valor: R$"+v.getValor()+ "\nLoja: "+v.getCodLoja().getNomeLoja());
		}

	}

	public void excluir() {
		System.out.println("Informe a Placa do veiculo que deseja excluir: ");
		String placa = scM.next();
		veDao.excluirVeiculo(placa);
	}
	/*
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
