package br.com.CRUDSpringHibernateMaven.service;

import javax.validation.ValidationException;

import br.com.CRUDSpringHibernateMaven.dao.UsuarioDao;
import br.com.CRUDSpringHibernateMaven.infra.MensagensPadronizadas;
import br.com.CRUDSpringHibernateMaven.model.Usuario;

public class LoginService {
	UsuarioDao usuarioDao = new UsuarioDao();

	public Usuario logar(Usuario usuario) {
		try {
			for (Usuario user : usuarioDao.listarTodosUsuarios()) {
				if (usuario.getUsername().toUpperCase().equals(user.getUsername().toUpperCase()) 
					&& usuario.getSenha().equals(user.getSenha())) {
					return user;
				}
			}

		} catch (ValidationException e) {
			throw new ValidationException(new MensagensPadronizadas().loginErro);
		}
		return null;
	}

}
