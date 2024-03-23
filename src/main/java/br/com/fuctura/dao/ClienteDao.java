package br.com.fuctura.dao;

import java.sql.SQLException;

import br.com.fuctura.entidades.Cliente;
import br.com.fuctura.entidades.Endereco;

public class ClienteDao extends Conexao {

	public Cliente save(Cliente t) {
		open();
		String sql = "insert into cliente (nome,cpf,telefone,num_endereco,cep_endereco) values (?,?,?,?,?)";
		try {
			stmt = db.prepareStatement(sql);
			stmt.setString(1, t.getNome());
			stmt.setString(2, t.getCpf());
			stmt.setString(3, t.getTelefone());
			stmt.setString(4, t.getNum_endereco());
			stmt.setString(5, t.getCep_endereco().getCep().replace("-", ""));
			if (stmt.executeUpdate() > 0) {
				System.out.println("Cliente inserido com sucesso!");
			} else {
				System.out.println("Erro ao tentar salvar o cliente!");
			}
			stmt.close();
			close();
		} catch (SQLException e) {
			System.out.println("Erro ao salvar o cliente: " + e.getMessage());
		}
		return t;
	}

	public Cliente consultarCPF(String cpf) {
		Cliente cl = new Cliente();

		open();
		String sql = "SELECT * FROM cliente c inner join endereco e on c.cep_endereco = e.cep WHERE c.cpf = ?";

		try {
			stmt = db.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			if (rs.next()) {
				cl.setNome(rs.getString("nome"));
				cl.setCpf(rs.getString("cpf"));
				cl.setTelefone(rs.getString("telefone"));
				cl.setNum_endereco(rs.getString("num_endereco"));
				Endereco end = new Endereco();

				end.setCep(rs.getString("cep"));
				end.setLogradouro(rs.getString("logradouro"));
				end.setComplemento(rs.getString("complemento"));
				end.setBairro(rs.getString("bairro"));
				end.setLocalidade(rs.getString("localidade"));
				end.setUf(rs.getString("uf"));

				cl.setCep_endereco(end);
				stmt.close();
				close();
				return cl;

			}
		} catch (SQLException e) {
			System.out.println("CPF informado não Cadastrado: " + cpf);
		}

		return cl;
	}

	public void excluirCPF(String cpf) {
		consultarCPF(cpf);
		String sql = "delete from cliente where cpf = ?";
		try {
			open();
			stmt = db.prepareStatement(sql);
			stmt.setString(1, cpf);
			if (stmt.executeUpdate() > 0) {
				System.err.println("Registro excluido com sucesso!");
			} else {
				System.out.println("Nenhum registro encontrado!");
			}

			stmt.close();
			close();
		} catch (Exception e) {
			System.err.println("Erro ao excluir cliente");
		}

	}

	public void atualizarCPF(String cpf, Cliente t) {

		Cliente cl = new Cliente();
		cl = consultarCPF(cpf);
		System.out.println("CPF: " + cl.getCpf());
		if (cl.getCpf() != null) {
			String sql = "update cliente set nome=?, telefone=?, num_endereco=?, cep_endereco=? WHERE cpf = ?";
			try {
				open();
				stmt = db.prepareStatement(sql);
				stmt.setString(1, t.getNome());
				stmt.setString(2, t.getTelefone());
				stmt.setString(3, t.getNum_endereco());
				stmt.setString(4, t.getCep_endereco().getCep().replace("-", ""));
				stmt.setString(5, cpf);
				if (stmt.executeUpdate() > 0) {
					System.out.println("Dados atualizado com sucesso!");
				} else {
					System.out.println("Erro ao atualizar os dados do cliente!");
				}
				stmt.close();
				close();
			} catch (SQLException e) {
				System.out.println("Erro ao salvar o cliente: " + e.getMessage());
			}

		}

	}
}