package br.com.fuctura.dao;

import java.sql.SQLException;

import br.com.fuctura.entidades.Loja;
import br.com.fuctura.entidades.Vendedor;

public class VendedorDao extends Conexao {

	public Vendedor save(Vendedor t) {
		open();
		String sql = "insert into vendedor (nome,cod_loja) values (?,?)";
		try {
			stmt = db.prepareStatement(sql);
			stmt.setString(1, t.getNome());
			stmt.setInt(2, t.getCodLoja().getCodLoja());

			if (stmt.executeUpdate() > 0) {
				System.out.println("Vendedor inserido com sucesso!");
			} else {
				System.out.println("Erro ao tentar salvar o Vendedor!");
			}
			stmt.close();
			close();
		} catch (SQLException e) {
			System.out.println("Erro ao salvar o cliente: " + e.getMessage());
		}
		return t;
	}

	public Vendedor consultarNome(String nome) {
		Vendedor cl = new Vendedor();
		Loja loja = new Loja();
		open();
		String sql = "SELECT * FROM vendedor c inner join loja e on c.cod_loja = e.cod_loja WHERE c.nome = ?";

		try {
			stmt = db.prepareStatement(sql);
			stmt.setString(1, nome);
			if ((rs = stmt.executeQuery()) != null) {
				if (rs.next()) {
					cl.setCodVendedor(rs.getInt("cod_vendedor"));
					cl.setNome(rs.getString("nome"));

					loja.setCodLoja(rs.getInt("cod_loja"));
					loja.setNomeLoja(rs.getString("nome_loja"));
					loja.setNumEndereco(rs.getString("num_endereco"));
					// loja.setCep_endereco(rs.getString("cep_endereco"));
					cl.setCodLoja(loja);

					stmt.close();
					close();

					return cl;
				}

			}

		} catch (Exception e) {
			System.out.println("Vendedor não Cadastrado: " + nome);
		}

		return cl;
	}

	public void excluirVendedor(String nome) {

		open();
		String sql = "delete FROM vendedor WHERE nome = ?";
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
			System.err.println("Erro ao excluir cliente");
		}

	}

	public void atualizarVendedor(String nome, Vendedor t) {

		Vendedor cl = new Vendedor();
		cl = consultarNome(nome);
		System.out.println("Vendedor: " + cl.getNome());
		String sql = "update vendedor set nome=?, cod_loja=? WHERE nome=?";
		try {
			open();
			stmt = db.prepareStatement(sql);
			stmt.setString(1, t.getNome());
			stmt.setInt(2, t.getCodLoja().getCodLoja());
			stmt.setString(3, nome);
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
