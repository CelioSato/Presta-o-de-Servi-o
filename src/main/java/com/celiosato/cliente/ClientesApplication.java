package com.celiosato.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.celiosato.cliente.domain.Cliente;
import com.celiosato.cliente.repositories.ClienteRepository;

@SpringBootApplication
public class ClientesApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente = new Cliente(null, "Celio Sato", "10773072845",null);
		clienteRepository.save(cliente);
	}

}
