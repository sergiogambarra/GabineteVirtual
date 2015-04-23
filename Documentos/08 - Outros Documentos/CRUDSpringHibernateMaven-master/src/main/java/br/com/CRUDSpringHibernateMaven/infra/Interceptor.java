package br.com.CRUDSpringHibernateMaven.infra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter{
	
	  @Override
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {

	      String uri = request.getRequestURI();
	      if(uri.endsWith("/login/login") ||
	          uri.endsWith("/login/logar")|| 
	          uri.endsWith("/usuario") ||
	          uri.endsWith("/usuario/cadastrarUsuario") ||
              uri.contains("resources")){
	        return true;
	      }

	      if(request.getSession().getAttribute("usuarioLogado") != null) {
	        return true;
	      }
	      
	      response.sendRedirect(request.getContextPath()+"/login/login");
	      return false;
	  }
}

