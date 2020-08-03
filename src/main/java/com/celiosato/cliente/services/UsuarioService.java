package com.celiosato.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiosato.cliente.domain.Usuario;
import com.celiosato.cliente.repositories.UsuarioRepository;
import com.celiosato.cliente.services.exception.UsuarioCadastradoException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		boolean exists = usuarioRepository.existsByUsername(obj.getUsername()); 
		if(exists) {
			throw new UsuarioCadastradoException(obj.getUsername());
		}
		obj = usuarioRepository.save(obj);
		return obj;
		
	}

}
