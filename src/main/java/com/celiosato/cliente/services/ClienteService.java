package com.celiosato.cliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.celiosato.cliente.domain.Cliente;
import com.celiosato.cliente.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findId(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );		
	}
	
	
	public List<Cliente> findAll() {
		List<Cliente> list = clienteRepository.findAll();
		return list;
	}
	
	public Cliente insert (Cliente obj) {
		obj.setId(null);
		obj = clienteRepository.save(obj);
		return obj;
		
	}
	
	public void delete(Integer id) {
		findId(id);
		try {
			clienteRepository.deleteById(id);
		}
		catch(ResponseStatusException e ) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
		}
	}
	
	public Cliente update(Integer id, Cliente obj) {
		Cliente newCliente = findId(obj.getId());
		updateData (newCliente, obj);
		return clienteRepository.save(newCliente);
	}

	private void updateData(Cliente newCliente, Cliente obj) {
		newCliente.setNome(obj.getNome());
		newCliente.setCpf(obj.getCpf());
		
	}

}
