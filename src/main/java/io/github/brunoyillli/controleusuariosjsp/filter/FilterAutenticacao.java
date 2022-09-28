package io.github.brunoyillli.controleusuariosjsp.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = { "/principal/*" })
public class FilterAutenticacao extends HttpFilter implements Filter {

	private static final long serialVersionUID = -2936508568794476384L;

	public FilterAutenticacao() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpSession session = servletRequest.getSession();

		String usuarioLogado = (String) session.getAttribute("usuario");
		String urlParaAutenticar = servletRequest.getServletPath();

		if (usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("/principal/Login")) {
			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("mensagem", "Por favor realize o login!");
			redireciona.forward(request, response);
			return;
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
