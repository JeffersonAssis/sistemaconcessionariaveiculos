package br.com.fuctura.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	
	protected ResultSet rs;
	protected PreparedStatement stmt;
	protected Connection db;
	protected CallableStatement call;
	
	public void open() {
			
		String url = "jdbc:postgresql://localhost:5432/gerenciamentoveiculo";
		String user = "postgres";
		String password = "postgres";
		
		try {
			Class.forName("org.postgresql.Driver");
			db = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Erro ao tentar conectar com banco: "+ e.getMessage());
		}
		 
	}
	
	public void close() throws SQLException {
		db.close();
	}

}
