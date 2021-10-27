package com.controleestoque.services;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleestoque.dtos.UsuarioDTO;
import com.controleestoque.entity.Usuario;
import com.controleestoque.repositories.UsuarioRepository;

import io.jsonwebtoken.Claims;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private TokenService tokenService;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, TokenService tokenService){
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    public Usuario registrate(Usuario user) {
    	
    	user = usuarioRepository.findByUsuarioAndSenha(user.getUsuario(), user.getSenha());
    	
        user.setToken(tokenService.generateToken(user));
        return usuarioRepository.save(user);
    }
    
    public Usuario authenticate(UsuarioDTO dados, String token){
    	Usuario user = usuarioRepository.buscarUsuarioByEmail(dados.getEmail());
    	
        if (user != null && dados.getSenha().equals(user.getSenha()) && !token.isEmpty() && validate(token)) {
            return user;
        } else {
            throw new RuntimeException();
        }
    }

    private boolean validate(String token) {
        try {
            String tokenTratado = token.replace("Bearer ", "");
            Claims claims = tokenService.decodeToken(tokenTratado);

            //Verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new RuntimeException();
            
            return true;
        } catch (RuntimeException et){
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

	public Usuario gravarUsuario(@Valid UsuarioDTO userRegistrationDTO) {

		Usuario usuario = userRegistrationDTO.toUser();
		
		return usuarioRepository.save(usuario);
	}
}
