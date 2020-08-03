package com.celiosato.cliente.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.celiosato.cliente.domain.Cliente;
import com.celiosato.cliente.services.ClienteService;

@RestController
@RequestMapping("/clientes")
//@CrossOrigin("http://localhost:4200")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente insert(@RequestBody @Valid Cliente obj ) {
		obj = clienteService.insert(obj);
		return obj;	
	}
	
	@GetMapping("{id}")
	public Cliente findId(@Valid @PathVariable Integer id) {
		Cliente obj = clienteService.findId(id);
	    return obj;
	}
	
	@GetMapping
	public List<Cliente> findAll(){
		List<Cliente> list = clienteService.findAll();
		return list;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@Valid @PathVariable Integer id) {
		clienteService.delete(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody @Valid Cliente cliente) {
		cliente.setId(id);
		cliente = clienteService.update(id, cliente);
	}

}
