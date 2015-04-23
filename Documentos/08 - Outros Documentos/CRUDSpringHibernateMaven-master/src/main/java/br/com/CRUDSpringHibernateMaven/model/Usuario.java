package br.com.CRUDSpringHibernateMaven.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private long id;

	@NotEmpty(message = "{nome.vazio}")
	@Size(min = 3, max = 20, message = "{nome.tamanho.errado}")
	private String nome;

	@NotEmpty(message = "{sobrenome.vazio}")
	@Size(min = 3, max = 20, message = "{sobrenome.tamanho.errado}")
	private String sobrenome;

	@NotEmpty(message = "{username.vazio}")
	@Size(min = 3, max = 20, message = "{username.tamanho.errado}")
	private String username;

	@NotEmpty(message = "{senha.vazio}")
	@Size(min = 3, max = 8, message = "{senha.tamanho.errado}")
	private String senha;

	@NotEmpty(message = "{confirmasenha.vazio}")
	@Size(min = 3, max = 8, message = "{confirmasenha.tamanho.errado}")
	private String confirmaSenha;

	@NotEmpty(message = "{email.vazio}")
	@Email(message = "{email.invalido}")
	private String email;

	private Date dataCadastro;

	private String tipoUsuario;

	public void toUpperCase() {
		this.nome = this.nome.toUpperCase();
		this.sobrenome = this.sobrenome.toUpperCase();
		this.username = this.username.toUpperCase();
		this.email = this.email.toUpperCase();
	}

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", username=" + username + ", senha=" + senha + ", confirmaSenha=" + confirmaSenha + ", email=" + email + ", dataCadastro=" + dataCadastro + ", tipoUsuario="
				+ tipoUsuario + "]";
	}

}
