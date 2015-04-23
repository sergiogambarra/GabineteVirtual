package br.com.CRUDSpringHibernateMaven.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.CRUDSpringHibernateMaven.infra.MensagensPadronizadas;
import br.com.CRUDSpringHibernateMaven.model.Produto;
import br.com.CRUDSpringHibernateMaven.service.ProdutoService;

@Controller
public class ProdutoController {
	private ProdutoService produtoService = new ProdutoService();
	private MensagensPadronizadas mensagensPadronizadas = new MensagensPadronizadas();

	@RequestMapping("/produto")
	public String paginaDeCadastro() {
		return "produto/PaginaDeCadastro";
	}

	@RequestMapping(value = "/produto/salvarProduto", method = RequestMethod.POST)
	public String salvarProduto(@Valid Produto produto, BindingResult result, ModelMap model) {
		String mensagem = null;

		if (result.hasFieldErrors("nome") || result.hasFieldErrors("descricao") || result.hasFieldErrors("preco")) {
			mensagem = mensagensPadronizadas.erroAoCadastrarProduto;
			model.addAttribute("mensagemTitulo", mensagem);
			return "forward:/produto";
		} else {
			try {

				produtoService.salvarProduto(produto);
				mensagem = mensagensPadronizadas.produtoAdicionadoComSucesso;

			} catch (ValidationException e) {
				mensagem = e.getMessage();
			}

			model.addAttribute("mensagemTitulo", mensagem);
			return "forward:/produto";
		}
	}

	@RequestMapping("/produto/visualizarProdutos")
	public String paginaDeLista(ModelMap model) {
		model.addAttribute("listaDeProdutos", produtoService.listaDeProdutos());
		return "produto/PaginaDeLista";
	}

	@RequestMapping("/produto/editar")
	public String paginaDeEdicao(Long produtoId, ModelMap model) {
		model.addAttribute("produto", produtoService.retornaProduto(produtoId));
		return "produto/PaginaDeEdicao";
	}

	@RequestMapping("/produto/salvarEdicao")
	public String salvarEdicao(@Valid Produto produto, BindingResult result, ModelMap model) {
		String mensagem = null;
		if (result.hasFieldErrors("nome") || result.hasFieldErrors("descricao") || result.hasFieldErrors("preco")) {
			mensagem = mensagensPadronizadas.erroAoEditarProduto;
			model.addAttribute("mensagemTitulo", mensagem);
			return "forward:/produto/editar";
		} else {
			produtoService.salvarEdicao(produto);
			mensagem = "Produto editado com sucesso!";
			model.addAttribute("mensagemTitulo", mensagem );
			return "forward:/produto/visualizarProdutos";
		}
	}
}
