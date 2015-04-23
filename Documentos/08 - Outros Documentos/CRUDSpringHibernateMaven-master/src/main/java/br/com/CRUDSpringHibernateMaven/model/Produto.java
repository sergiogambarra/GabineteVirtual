package br.com.CRUDSpringHibernateMaven.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Produto {
	// MensagensPadronizadas mensagens = new MensagensPadronizadas();

	@Id
	@GeneratedValue
	private long id;

	@NotEmpty(message = "{nome.vazio}")
	@Size(min = 5, max = 20, message = "{nome.tamanho.errado}")
	private String nome;

	@NotEmpty(message = "{descricao.vazio}!")
	@Size(min = 5, max = 20, message = "{descricao.tamanho.errado}")
	private String descricao;

	@NotNull
	@Min(value = 1, message = "{preco.maior.um}")
	private double preco;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro;

	private int idUsuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", dataCadastro=" + dataCadastro + ", idUsuario=" + idUsuario + "]";
	}

}
