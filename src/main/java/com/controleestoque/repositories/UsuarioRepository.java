package com.controleestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controleestoque.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	   @Query(" select u FROM Usuario u " +
    		" WHERE u.email = :email " )
     Usuario buscarUsuarioByEmail(
             @Param("email") String email);

	   @Query(" select u FROM Usuario u " +
	    		" WHERE u.usuario = :usuario" +
	    		" 	AND u.senha = :senha " )
	   Usuario findByUsuarioAndSenha(
	   		@Param("usuario") String usuario,
	   		@Param("senha") String senha);

}
