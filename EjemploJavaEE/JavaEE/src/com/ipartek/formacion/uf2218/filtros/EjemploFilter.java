package com.ipartek.formacion.uf2218.filtros;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.ipartek.formacion.uf2218.modelo.Usuario;

@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/admin/*" })
public class EjemploFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
		
		if(usuario == null) {
			httpRequest.getRequestDispatcher("/login").forward(request, response);
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void destroy() {
		
	}
}
