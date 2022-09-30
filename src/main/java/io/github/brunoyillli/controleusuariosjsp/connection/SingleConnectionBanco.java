package io.github.brunoyillli.controleusuariosjsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	private static String banco = "jdbc:postgresql://localhost:5432/controle-usuario-jsp?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnectionBanco() {
		conectar();
	}

	public static Connection getConnection() {
		return connection;
	}
	
	private static void conectar() {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
