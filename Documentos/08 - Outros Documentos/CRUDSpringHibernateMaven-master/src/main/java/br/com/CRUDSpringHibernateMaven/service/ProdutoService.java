package br.com.CRUDSpringHibernateMaven.service;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import br.com.CRUDSpringHibernateMaven.dao.ProdutoDao;
import br.com.CRUDSpringHibernateMaven.model.Produto;

public class ProdutoService {
	private ProdutoDao produtoDao = new ProdutoDao();
//	private MensagensPadronizadas mensagensPadronizadas = new MensagensPadronizadas();
	
	
	public void salvarProduto(Produto produto){		
		//validaProduto(produto);				
		try{
			produto.setDataCadastro(new Date());
			produtoDao.salvarProduto(produto);
		}catch(ValidationException e){
			System.out.println("Erro no ProdutoService - SalvarProduto: "+e);
		}
	}
	
	public List<Produto> listaDeProdutos(){
		List<Produto> listaProduto = produtoDao.listaDeProdutos();
		return listaProduto;		
	}
	
	public Produto retornaProduto(Long produtoId){
		return produtoDao.retornaProduto(produtoId);
	}
	
	public void salvarEdicao(Produto produto){
		produtoDao.salvarEdicao(produto);
	}
	
//	private void validaProduto(Produto produto){
//		if(produto.getPreco() < 700){
//			throw new ValidationException(mensagensPadronizadas.precoIncompativel);
//		}		
//	}
}
