package br.com.CRUDSpringHibernateMaven.infra;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.CRUDSpringHibernateMaven.model.Produto;

public class TestaConexao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = new FabricaDeSessao().getSession();
		Transaction tx = session.beginTransaction();
		Produto produto = criaProduto();
		try{
			session.save(produto);
			tx.commit();
		}catch(Exception e){
			System.out.println("Erro no teste de conexao: "+e);
		}finally{
			session.close();
		}
	}
	
	private static Produto criaProduto(){
		Produto produto = new Produto();
		produto.setNome("Tenis Adidas");
		produto.setDescricao("Tenis de skate adidas!");
		produto.setPreco(333.0);
		produto.setDataCadastro(new Date());
		return produto;
	}

}
