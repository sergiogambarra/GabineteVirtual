package br.com.CRUDSpringHibernateMaven.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.CRUDSpringHibernateMaven.model.Usuario;
import br.com.CRUDSpringHibernateMaven.service.UsuarioService;

@Controller
public class UsuarioController {
	UsuarioService usuarioService = new UsuarioService();
	MenuController menu = new MenuController();
	
	@RequestMapping(value="/usuario", method = RequestMethod.GET)
	public String paginaDeCadastro(){		
		return "usuario/PaginaDeCadastro";
	}
	
	@RequestMapping(value="/usuario/cadastrarUsuario", method=RequestMethod.POST)
	public String cadastrarUsuario(@Valid Usuario usuario, BindingResult result, ModelMap model){
		String mensagem = null;
		
		if(result.hasFieldErrors("nome") || result.hasFieldErrors("sobrenome") ||
			result.hasFieldErrors("email") || result.hasFieldErrors("username") ||
			result.hasFieldErrors("senha") || result.hasFieldErrors("confirmaSenha") ){
			
			mensagem = "Erro ao cadastrar usuário!";
			model.addAttribute("mensagemTitulo", mensagem);
			return "forward:/usuario";
			
		}else{
			try{
				
				usuarioService.cadastrarUsuario(usuario);
				mensagem = "Usuário cadastrado com sucesso!";
				
			} catch (ValidationException e) {
				mensagem = e.getMessage();
				model.addAttribute("mensagemTitulo", mensagem);
				return "forward:/usuario";
			}
			
			model.addAttribute("mensagemTitulo", mensagem);
			return "forward:/login/login";
		}
	}
}