package br.com.fuctura.dao;

import java.sql.SQLException;

import br.com.fuctura.entidades.Endereco;

public class EnderecoDao extends Conexao {

	public Endereco save(Endereco t) {
		open();
		String sql = "insert into endereco (cep,logradouro,complemento,bairro,localidade,uf) values (?,?,?,?,?,?)";
		try {
			stmt  =  db.prepareStatement(sql);
			stmt.setString(1, t.getCep().replace("-", ""));
			stmt.setString(2, t.getLogradouro());
			stmt.setString(3, t.getComplemento());
			stmt.setString(4, t.getBairro());
			stmt.setString(5, t.getLocalidade());
			stmt.setString(6, t.getUf());
			stmt.execute();
			stmt.close();
			close();
		} catch (SQLException e) {
			System.out.println("Erro ao salvar o endereco: "+ e.getMessage());
			
		}		
		return t;
	}

	public Endereco consultar(String cep) {
		open();
		Endereco end = new Endereco();
		String sql = "select * from endereco where cep = ?";
		try {
			stmt  =  db.prepareStatement(sql);
			stmt.setString(1, cep);
			if((rs = stmt.executeQuery())!=null) {
				if(rs.next()) {
					end.setCep(rs.getString("cep"));
					end.setLogradouro(rs.getString("logradouro"));
					end.setBairro(rs.getString("bairro"));
					end.setComplemento(rs.getString("complemento"));
					end.setLocalidade(rs.getString("localidade"));
					end.setUf(rs.getString("uf"));
					
				}
			}
			stmt.close();
			close();
			return end;
		} catch (SQLException e) {
			System.out.println("Erro ao buscar o endereco: "+ e.getMessage());
			
		}		
	return end;
	}


	public void atualizar(String id, Endereco t) {
		open();
		String sql = "select * from endereco where cep = ?";
		try {
			stmt  =  db.prepareStatement(sql);
			stmt.setString(1, id);
			if(stmt.executeQuery()!=null) {
				String sqlU = "Update endereco set complemento=?, bairro=?, logradouro=? where cep = ?";
				stmt  =  db.prepareStatement(sqlU);
				stmt.setString(1, t.getComplemento());
				stmt.setString(2, t.getBairro());
				stmt.setString(2, t.getLogradouro());
				stmt.setString(5, id);
				stmt.execute();
				stmt.close();
				close();
			}else {
				System.out.println("CEP informado não cadastrado! "+id);
			}
		
		} catch (Exception e) {
			System.out.println("Erro ao atualizar dados do Endereco: "+e);
		}
		
	}

	
	public void delete(String id) {
		open();
		String sql = "delete form endereco where cep = ?";
		try {
			stmt = db.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.execute();
			stmt.close();
			close();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir o Endereco: "+id+" - "+ e.getMessage());
		}
		
	}

}
