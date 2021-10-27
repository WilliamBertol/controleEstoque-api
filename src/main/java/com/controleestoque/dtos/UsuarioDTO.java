package com.controleestoque.dtos;

import com.controleestoque.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UsuarioDTO {

	private Long idUsuario;

	private String email;
	
	private String usuario;

	private String senha;
	
	private String token;

    public UsuarioDTO(){}

    public static UsuarioDTO toDTO(Usuario user) {
        return new UsuarioDTO(user.getUsuario(), user.getEmail(), user.getSenha(), user.getToken());
    }
    
    public Usuario toUser() {
        return new Usuario(getUsuario(), getEmail(), getSenha());
    }
    
    public UsuarioDTO(String usuario, String email, String senha, String token){
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.token = token;
    }
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
