package io.github.brunoyillli.controleusuariosjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.github.brunoyillli.controleusuariosjsp.connection.SingleConnectionBanco;
import io.github.brunoyillli.controleusuariosjsp.model.ModelLogin;

public class DAOUsuarioRepository {
	
	private Connection connection;
	
	public DAOUsuarioRepository() {
		connection = SingleConnectionBanco.getConnection();
	}

	public void gravarUsuario(ModelLogin login) throws SQLException {
		
		String sql = "INSERT INTO model_login(login,senha,nome,email) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, login.getLogin());
		preparedStatement.setString(2, login.getSenha());
		preparedStatement.setString(3, login.getNome());
		preparedStatement.setString(4, login.getEmail());
		preparedStatement.execute();
		
		connection.commit();
		
	}
}
