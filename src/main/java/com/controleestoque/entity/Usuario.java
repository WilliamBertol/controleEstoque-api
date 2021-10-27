package com.controleestoque.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@NotEmpty(message = "Campo Email é requerido!")
	@Length(min = 1, max = 300, message = "O campo Email deve ter entre 1 e 15 caracteres!")
	@Email
	private String email;
	
	@NotEmpty(message = "Campo Usuário é requerido!")
	@Length(min = 1, max = 20, message = "O campo Usuário deve ter entre 1 e 300 caracteres!")
	private String usuario;

	@NotEmpty(message = "Campo Senha é requerido!")
	@Length(min = 1, max = 20, message = "O campo Senha deve ter entre 1 e 20 caracteres!")
	private String senha;
	
	private String token;
	
	public Usuario() {
		
	}

	public Usuario(String usuario, String email, String senha) {
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
