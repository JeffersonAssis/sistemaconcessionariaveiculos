package br.com.fuctura.dao;

import java.sql.SQLException;

import br.com.fuctura.entidades.Loja;
import br.com.fuctura.entidades.TipoVeiculo;
import br.com.fuctura.entidades.Veiculo;

public class VeiculoDao extends Conexao{
	
	public void save(Veiculo v) {
	
		try {
			open();
			String sql = "insert into veiculo (placa,modelo,ano,valor,cod_tipo,cod_loja) values (?,?,?,?,?,?)";
			stmt = db.prepareStatement(sql);
			stmt.setString(1, v.getPlaca());
			stmt.setString(2, v.getModelo());
			stmt.setInt(3,v.getAno());
			stmt.setFloat(4, v.getValor());
			stmt.setLong(5, v.getTipoVeiculo().getCodTipo());
			stmt.setLong(6, v.getCodLoja().getCodLoja());
			if(stmt.executeUpdate()>0) {
				System.out.println("Veiculo Cadastrado Com sucesso!");
			}else {
				System.out.println("Erro ao tentar cadastrar o veiculo!");
			}
			stmt.close();
			close();
		} catch (Exception e) {
			System.out.println("Erro ao tentar cadastrar o veiculo!");
		}
		
	}

	public Veiculo consultarPlaca(String placa) {
		Veiculo v = new Veiculo();
		try {
			open();
			String sql = "select * from veiculo v join loja l on v.cod_loja = l.cod_loja"
					+ " join tipo_veiculo tv on v.cod_tipo = tv.cod_tipo  where placa= ?";
			stmt = db.prepareStatement(sql);
			stmt.setString(1, placa);
			if((rs = stmt.executeQuery())!=null) {
				if(rs.next()) {
					Loja l = new Loja();
					TipoVeiculo tv = new TipoVeiculo();
					v.setPlaca(rs.getString("placa"));
					v.setModelo(rs.getString("modelo"));
					v.setAno(rs.getInt("ano"));
					v.setValor(rs.getFloat("valor"));
					l.setNomeLoja(rs.getString("nome_loja"));
					l.setCodLoja(rs.getInt("cod_loja"));
					v.setCodLoja(l);
					tv.setCodTipo(rs.getLong("cod_tipo"));
					tv.setTipoVeiculo(rs.getString("descricao"));
					v.setTipoVeiculo(tv);
					stmt.close();
					close();
					return v;
				}
			}else {
				System.out.println("Nenhum veiculo cadastrado com essa placa: "+placa);
			}
		}catch (Exception e) {
			System.out.println("Erro ao consultar a placa do veiculo, "+e);
		}
		return v;
	}

	public void excluirVeiculo(String placa) {
		open();
		String sql = "delete from veiculo where placa = ?";
		try {
			stmt = db.prepareStatement(sql);
			stmt.setString(1, placa);
			if(stmt.executeUpdate()>0) {
				System.out.println("Veiculo excluido com sucesso "+placa);
			}else {
				System.out.println("Nenhum registro encontrado!");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao tentar excluir o veiculo, "+e);
		}
		
	}

}