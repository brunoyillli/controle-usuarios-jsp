package io.github.brunoyillli.controleusuariosjsp.servlets;

import java.io.IOException;

import io.github.brunoyillli.controleusuariosjsp.dao.DAOUsuarioRepository;
import io.github.brunoyillli.controleusuariosjsp.model.ModelLogin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Usuario")
public class ServletUsuarioController extends HttpServlet {

	private static final long serialVersionUID = -3474133777043285038L;

	private DAOUsuarioRepository daoUsuarioRepository = new DAOUsuarioRepository();

	public ServletUsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String mensagem = "Operação realizada com sucesso!";

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelLogin.setNome(nome);
			modelLogin.setEmail(email);
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);

			if (daoUsuarioRepository.validarLogin(modelLogin.getLogin()) && modelLogin.getId() == null) {
				mensagem = "Já existe usuario com o mesmo login, informe outro login";
			} else {
				if(modelLogin.isNovo()) {
					mensagem = "Gravado com sucesso!";
				}else {
					mensagem = "Atualizado com sucesso!";
				}
				
				modelLogin = daoUsuarioRepository.gravarUsuario(modelLogin);
			}

			request.setAttribute("mensagem", mensagem);
			request.setAttribute("modelLogin", modelLogin);

			RequestDispatcher redireciona = request.getRequestDispatcher("principal/usuario.jsp");
			redireciona.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("mensagemErro", e.getMessage());
			redirecionar.forward(request, response);
		}
	}

}
