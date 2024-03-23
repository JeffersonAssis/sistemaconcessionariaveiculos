package br.com.fuctura.controle;

import java.util.Scanner;

import br.com.fuctura.dao.ClienteDao;
import br.com.fuctura.entidades.Cliente;
import br.com.fuctura.entidades.Endereco;

public class ClienteControle {
	static ClienteDao clDao = new ClienteDao();
	final static Scanner scM = new Scanner(System.in);

	public void cadastra() throws Exception {
		EnderecoControle e = new EnderecoControle();
		Cliente c = new Cliente();
		System.out.print("Nome: ");
		c.setNome(scM.next());
		System.out.print("CPF: ");
		c.setCpf(scM.next());
		System.out.print("Telefone: ");
		c.setTelefone(scM.next());
		Endereco end = e.buscar();
		c.setCep_endereco(end);
		System.out.print("Nº da residência: ");
		c.setNum_endereco(scM.next());

		c = clDao.save(c);

	}

	public Cliente buscar() {

		Cliente c = new Cliente();
		String cpf;

		System.out.println("Informe o CPF: ");
		cpf = scM.next();

		c = clDao.consultarCPF(cpf);

		if(c.getCpf()!=null) {
		System.out.println("Nome: " + c.getNome() + " CPF - " + c.getCpf() + "\nTelefone: " + c.getTelefone()
				+ "\nEndereco: " + c.getCep_endereco().getLogradouro() + " - " + c.getNum_endereco() + "\nBairro: "
				+ c.getCep_endereco().getBairro() + " - " + c.getCep_endereco().getLocalidade() + "/"
				+ c.getCep_endereco().getUf());
		}
		else {
			System.out.println("Cliente não cadastrado!");
		}
		return c;

	}

	public void excluir() {
		String cpf;
		System.out.println("Informe o CPF: ");
		cpf = scM.next();
		clDao.excluirCPF(cpf);
	}
	
	public void atualizar() throws Exception {
		EnderecoControle e = new EnderecoControle();
		Cliente c = new Cliente();
		System.out.print("CPF: ");
		String cpf = scM.next();
		c = clDao.consultarCPF(cpf);

		System.out.println("Nome: " + c.getNome() + " CPF - " + c.getCpf() + "\nTelefone: " + c.getTelefone()
				+ "\nEndereco: " + c.getCep_endereco().getLogradouro() + " - " + c.getNum_endereco() + "\nBairro: "
				+ c.getCep_endereco().getBairro() + " - " + c.getCep_endereco().getLocalidade() + "/"
				+ c.getCep_endereco().getUf());
		
		System.out.print("Nome: ");
		c.setNome(scM.next());
		System.out.print("Telefone: ");
		c.setTelefone(scM.next());
		Endereco end = e.buscar();
		c.setCep_endereco(end);
		System.out.print("Nº da residência: ");
		c.setNum_endereco(scM.next());

	 clDao.atualizarCPF(cpf,c);
	}
}
