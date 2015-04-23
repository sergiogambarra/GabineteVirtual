package br.com.CRUDSpringHibernateMaven.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.CRUDSpringHibernateMaven.infra.FabricaDeSessao;
import br.com.CRUDSpringHibernateMaven.model.Produto;
import br.com.CRUDSpringHibernateMaven.model.Usuario;

public class ProdutoDao {

	public void salvarProduto(Produto produto) {
		Session session = new FabricaDeSessao().getSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(produto);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erro no ProdutoDao - SalvarProduto: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listaDeProdutos() {
		Session session = new FabricaDeSessao().getSession();
		Query query = session.createQuery("from Produto");
		return (List<Produto>) query.list();
	}

	public Produto retornaProduto(Long produtoId) {
		Session session = new FabricaDeSessao().getSession();
		Query query = session.createQuery("from Produto where 0 = 0 and id = " + String.valueOf(produtoId));
		return (Produto) query.uniqueResult();
	}

	public void salvarEdicao(Produto produto) {
		Session session = new FabricaDeSessao().getSession();
		Transaction tx = session.beginTransaction();
		try {

			session.update(produto);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erro no ProdutoDao - salvarEdicao: " + e.getMessage());
		} finally {
			session.clear();
			session.close();
		}
	}
}
