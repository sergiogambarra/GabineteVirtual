package br.com.CRUDSpringHibernateMaven.service;



import java.util.Date;

import javax.validation.ValidationException;

import br.com.CRUDSpringHibernateMaven.dao.UsuarioDao;
import br.com.CRUDSpringHibernateMaven.infra.MensagensPadronizadas;
import br.com.CRUDSpringHibernateMaven.model.Usuario;

public class UsuarioService {
	UsuarioDao usuarioDao = new UsuarioDao();
	
	public void cadastrarUsuario(Usuario usuario){
		usuario.toUpperCase();
		validaUsuario(usuario);
		
		try{
			usuario.setDataCadastro(new Date());
			
			usuarioDao.cadastrarUsuario(usuario);
		}catch(ValidationException e){
			System.out.println("Erro no UsuarioService - cadastrarUsuario: "+e);
		}
	}
	
	public void validaUsuario(Usuario usuario){
		if(!usuario.getSenha().equals(usuario.getConfirmaSenha())){
			throw new ValidationException(new MensagensPadronizadas().senhasIncompativeis);
		}
		
		for(Usuario user:usuarioDao.listarTodosUsuarios()){
			
			if(usuario.getUsername().toUpperCase().equals(user.getUsername().toUpperCase())){
				throw new ValidationException(new MensagensPadronizadas().usernameJaCadastrado);
			}
			
			if(usuario.getEmail().toUpperCase().equals(user.getEmail().toUpperCase())){
				throw new ValidationException(new MensagensPadronizadas().emailJaCadastrado);
			}
			
		}
	}
}
