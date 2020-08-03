package com.celiosato.cliente.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.celiosato.cliente.domain.Usuario;
import com.celiosato.cliente.services.UsuarioService;
import com.celiosato.cliente.services.exception.UsuarioCadastradoException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario insert(@RequestBody @Valid Usuario obj ) {
		try {
			obj = usuarioService.insert(obj);	
			return obj;	
		}catch (UsuarioCadastradoException e) {
			throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
