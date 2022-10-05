package io.github.brunoyillli.controleusuariosjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.brunoyillli.controleusuariosjsp.connection.SingleConnectionBanco;
import io.github.brunoyillli.controleusuariosjsp.model.ModelLogin;

public class DAOLoginRepository {
	private Connection connection;

	public DAOLoginRepository() {
		this.connection = SingleConnectionBanco.getConnection();
	}

	public boolean validarAutenticacao(ModelLogin modelLogin) throws SQLException {
		String sql = "select * from model_login where login = ? and senha = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			return true;
		}
		return false;
	}
}
