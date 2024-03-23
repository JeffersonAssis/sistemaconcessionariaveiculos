package br.com.fuctura.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidades.Endereco;
import br.com.fuctura.entidades.Loja;

public class LojaDao extends Conexao {

	
	public Loja save(Loja t) {
		open();
		String sql = "insert into loja (nome_loja,num_endereco,cep_endereco) values (?,?,?)";
		try {
			stmt = db.prepareStatement(sql);
			stmt.setString(1, t.getNomeLoja());
			stmt.setString(2, t.getNumEndereco());
			stmt.setString(3, t.getCep_endereco().getCep().replace("-", ""));
			if (stmt.executeUpdate() > 0) {
				System.out.println("Loja cadastrada com sucesso!");
			} else {
				System.out.println("Erro ao cadastrar a loja!");
			}
			stmt.close();
			close();
		} catch (SQLException e) {
			System.out.println("Erro ao salvar a loja: " + e.getMessage());
		}
		return t;
	}

	public List<Loja> listarTodasLoja(){
		List<Loja> lloja = new ArrayList<Loja>();
 		
		open();
		String sql = "SELECT * FROM loja l inner join endereco e on l.cep_endereco = e.cep";

		try {
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Loja l = new Loja();
				Endereco end = new Endereco();
				l.setCodLoja(rs.getInt("cod_loja"));
				l.setNomeLoja(rs.getString("nome_loja"));
				l.setNumEndereco(rs.getString("num_endereco"));
		
				end.setCep(rs.getString("cep"));
				end.setLogradouro(rs.getString("logradouro"));
				end.setComplemento(rs.getString("complemento"));
				end.setBairro(rs.getString("bairro"));
				end.setLocalidade(rs.getString("localidade"));
				end.setUf(rs.getString("uf"));
				l.setCep_endereco(end);

				lloja.add(l);
			}
				stmt.close();
				close();
				return lloja;

			}
		 catch (SQLException e) {
			System.out.println("Erro ao tentar listar todas as loja!");
		}
		
		return lloja;
	}
	
	public void excluirLoja(String nome) {

		open();
			String sql = "delete FROM loja WHERE nome_loja = ?";
			try {
				stmt = db.prepareStatement(sql);
				stmt.setString(1, nome);
				if (stmt.executeUpdate() > 0) {
					System.err.println("Registro excluido com sucesso!");
				} else {
					System.out.println("Nenhum registro encontrado!");
				}

				stmt.close();
				close();
			} catch (Exception e) {
				System.err.println("Erro ao tentar excluir loja!");
			}
		
	}

	public void atualizarLoja(String nomeLoja, Loja t) {

			String sql = "update loja set nome_loja=?, num_endereco=?, cep_endereco=? WHERE nome_loja = ?";
			try {
				open();
				stmt = db.prepareStatement(sql);
				stmt.setString(1, t.getNomeLoja());
				stmt.setString(2, t.getNumEndereco());
				stmt.setString(3, t.getCep_endereco().getCep().replace("-", ""));
				stmt.setString(4, nomeLoja);
				if (stmt.executeUpdate() > 0) {
					System.out.println("Dados atualizado com sucesso!");
				} else {
					System.out.println("Erro ao atualizar os dados da loja!");
				}
				stmt.close();
				close();
			} catch (SQLException e) {
				System.out.println("Erro ao atualizar a loja: " + e.getMessage());
			}

		}

	public Loja buscarLoja(String nome) {
		Loja l = new Loja();
		Endereco end = new Endereco();
		open();
		String sql = "SELECT * FROM loja l inner join endereco e on l.cep_endereco = e.cep where nome_loja = ?";

		try {
			stmt = db.prepareStatement(sql);
			stmt.setString(1, nome);
			if((rs = stmt.executeQuery()) != null ) {
			if (rs.next()) {
				l.setCodLoja(rs.getInt("cod_loja"));
				l.setNomeLoja(rs.getString("nome_loja"));
				l.setNumEndereco(rs.getString("num_endereco"));
		
				end.setCep(rs.getString("cep"));
				end.setLogradouro(rs.getString("logradouro"));
				end.setComplemento(rs.getString("complemento"));
				end.setBairro(rs.getString("bairro"));
				end.setLocalidade(rs.getString("localidade"));
				end.setUf(rs.getString("uf"));
				l.setCep_endereco(end);
			}else {
				System.out.println("Loja não Encontrada!");
			}
			
				stmt.close();
				close();
				return l;
			}
			}
		 catch (SQLException e) {
			System.out.println("Erro ao tentar listar todas as loja!");
		}
		
		return l;
	}


}
