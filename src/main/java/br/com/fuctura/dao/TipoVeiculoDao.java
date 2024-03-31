package br.com.fuctura.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidades.TipoVeiculo;

public class TipoVeiculoDao extends Conexao{

	public void cadastraTipoVeiculo(TipoVeiculo tveiculo) {
		open();
		String sql = "insert into tipo_veiculo (descricao) values (?)";
		try {
			stmt = db.prepareStatement(sql);
			stmt.setString(1, tveiculo.getTipoVeiculo().toUpperCase());
			if(stmt.executeLargeUpdate()>0) {
				System.out.println("Cadastro realizado com sucesso!");
			}else {
				System.out.println("Erro ao Cadastra o tipo de Veiculo!");
			}
			stmt.close();
			close();
		} catch (SQLException e) {
			System.out.println("Erro ao tenta salvar tipo de veiculos, "+e);
		}
	}
	
	public List<TipoVeiculo> listaTipoVeiculo(){
		List<TipoVeiculo> ltipoVeiculo = new ArrayList<TipoVeiculo>();
 		open();
		try {
			String sql = "select * from tipo_veiculo";
			stmt = db.prepareStatement(sql);
			if((rs = stmt.executeQuery()) !=null){
				while(rs.next()) {
					TipoVeiculo t = new TipoVeiculo();
					t.setCodTipo(rs.getLong("cod_tipo"));
					t.setTipoVeiculo(rs.getString("descricao"));
					ltipoVeiculo.add(t);
				}
			}
			return ltipoVeiculo;
		} catch (Exception e) {
			System.out.println("Erro ao tentar listar os tipos de veiculos! "+e);
		}
		return ltipoVeiculo;
	}
}
