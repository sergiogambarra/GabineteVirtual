package br.com.CRUDSpringHibernateMaven.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.CRUDSpringHibernateMaven.infra.FabricaDeSessao;
import br.com.CRUDSpringHibernateMaven.model.Usuario;

public class UsuarioDao {
	
	public void cadastrarUsuario(Usuario usuario){
		Session session = new FabricaDeSessao().getSession();
		Transaction tx = session.beginTransaction();
		
		try{
			session.save(usuario);
			tx.commit();
		}catch(Exception e){
			System.out.println("Erro no UsuarioDao - cadastrarUsuario: "+e);
		}finally{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodosUsuarios(){
		Session session = new FabricaDeSessao().getSession();
		Query query = session.createQuery("from Usuario");
		return (List<Usuario>)query.list();
	}
}
