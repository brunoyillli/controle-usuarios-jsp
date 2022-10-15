package io.github.brunoyillli.controleusuariosjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.brunoyillli.controleusuariosjsp.connection.SingleConnectionBanco;
import io.github.brunoyillli.controleusuariosjsp.model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection connection;

	public DAOUsuarioRepository() {
		connection = SingleConnectionBanco.getConnection();
	}

	public ModelLogin gravarUsuario(ModelLogin login) throws SQLException {

		if (login.isNovo()) {

			String sql = "INSERT INTO model_login(login,senha,nome,email) VALUES (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, login.getLogin());
			preparedStatement.setString(2, login.getSenha());
			preparedStatement.setString(3, login.getNome());
			preparedStatement.setString(4, login.getEmail());
			preparedStatement.execute();

			connection.commit();

		} else {
			String sql = "UPDATE model_login SET login=?, senha=?, nome=?,email=? WHERE id = " + login.getId() + ";";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, login.getLogin());
			preparedStatement.setString(2, login.getSenha());
			preparedStatement.setString(3, login.getNome());
			preparedStatement.setString(4, login.getEmail());
			preparedStatement.executeUpdate();
			
			connection.commit();
		}
		
		return this.consultaUsuario(login.getLogin());

	}

	public ModelLogin consultaUsuario(String login) throws SQLException {
		ModelLogin modelLogin = new ModelLogin();
		String sql = "SELECT * FROM model_login where upper(login) = upper('" + login + "')";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		ResultSet resultado = preparedStatement.executeQuery();

		while (resultado.next()) {
			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setEmail(resultado.getString("email"));
			modelLogin.setLogin(resultado.getString("login"));
			modelLogin.setSenha(resultado.getString("senha"));
			modelLogin.setNome(resultado.getString("nome"));
		}

		return modelLogin;
	}

	public boolean validarLogin(String login) throws SQLException {
		String sql = "SELECT COUNT(1) > 0 as existe FROM model_login WHERE upper(login) = upper('" + login + "')";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultado = preparedStatement.executeQuery();

		resultado.next();
		return resultado.getBoolean("existe");

	}
}
