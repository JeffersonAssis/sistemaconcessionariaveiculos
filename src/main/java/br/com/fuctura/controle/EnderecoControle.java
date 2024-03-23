package br.com.fuctura.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.fuctura.dao.EnderecoDao;
import br.com.fuctura.entidades.Endereco;

public class EnderecoControle {

	static final Scanner scM = new Scanner(System.in);
	protected static EnderecoDao endDao = new EnderecoDao();

	static Endereco buscarCep(String cep){

		Endereco end = new Endereco();
		try {
		URL url;
		
			url = new URL("https://viacep.com.br/ws/"+ cep +"/json/");
		URLConnection conn = url.openConnection();
		
		InputStream is = conn.getInputStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		String endpo = "";
		StringBuffer jsonEnd = new StringBuffer();

		while ((endpo = buffer.readLine()) != null) {

			jsonEnd.append(endpo);
		}
		Endereco endaux = new Gson().fromJson(jsonEnd.toString(), Endereco.class);

		end.setBairro(endaux.getBairro());
		end.setCep(endaux.getCep());
		end.setComplemento(endaux.getComplemento());
		end.setLocalidade(endaux.getLocalidade());
		end.setLogradouro(endaux.getLogradouro());
		end.setUf(endaux.getUf());
		} catch (IOException e) {
			
			System.out.println("Erro ao consultar o CEP: "+e);
		}

		return end;

	}

	public static Endereco cadastraCep(String cep) throws Exception {

		
		if(cep.isEmpty()) {
			System.out.println("Informe o CEP?");
		cep = scM.next();
		}
		Endereco end = buscarCep(cep);
		System.out.println("Endereco "+end.getCep()+" - "+end.getLogradouro());
		if(end.getCep()!=null) {
			return end = endDao.save(end);
		}
		return end;
	}
	
	public Endereco buscar() throws Exception {
		Endereco end = new Endereco();
		String cep;
		System.out.println("Informe o CEP?");
		 cep = scM.next();
		try {
			end = endDao.consultar(cep);
		} catch (Exception e) {
			System.out.println("Endereco não cadastrado");
		}
		if(end.getCep() != null) {
			return end;
		}else {
			System.out.println("Endereco não cadastrado cadastrado");
			 end = cadastraCep(cep);
			 return end;
		}
	}
}
