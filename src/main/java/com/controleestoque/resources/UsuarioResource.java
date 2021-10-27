package com.controleestoque.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleestoque.dtos.UsuarioDTO;
import com.controleestoque.entity.Usuario;
import com.controleestoque.services.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

	private UsuarioService usuarioService;
	
	@Autowired
    public void UserRegistrationController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public void UserRegistrationController(){

    } 

    @PostMapping
    public ResponseEntity<UsuarioDTO> registrate(@RequestBody UsuarioDTO userRegistrationDTO){
        Usuario user = usuarioService.registrate(userRegistrationDTO.toUser());
        return new ResponseEntity<UsuarioDTO>(UsuarioDTO.toDTO(user), HttpStatus.OK);
    }
    
	@PostMapping("/gravar")
	public ResponseEntity<UsuarioDTO> gravarProduto(@RequestBody @Valid UsuarioDTO userRegistrationDTO, @RequestHeader String Authorization) {
		Usuario usuarioRetorno = usuarioService.authenticate(userRegistrationDTO, Authorization);
		
		return new ResponseEntity<UsuarioDTO>(UsuarioDTO.toDTO(usuarioRetorno), HttpStatus.CREATED);
	}
}
