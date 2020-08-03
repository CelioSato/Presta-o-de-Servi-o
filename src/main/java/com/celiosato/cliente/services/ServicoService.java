package com.celiosato.cliente.services;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiosato.cliente.domain.Cliente;
import com.celiosato.cliente.domain.Servico;
import com.celiosato.cliente.dto.ServicoDTO;
import com.celiosato.cliente.repositories.ServicoRepository;
import com.celiosato.cliente.util.BigDecimalConvert;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private BigDecimalConvert bigDecimalConvert;
	
	public Cliente find(Integer id) {
		Cliente obj = clienteService.findId(id);
			return obj;
	}
	

	public Servico insert(Servico obj) {
		obj.setId(null);
		obj = servicoRepository.save(obj);
		return obj;
	}
	
	
	
	/*public Servico insert (Servico obj) {
		Cliente newObj = clienteService.findId(obj.getId());
		if(newObj == null) {
			return null;
		}
		Servico newServ = new Servico(null, obj.getDescricao(), obj.getPreco(), obj.getDataCadastro(), newObj);
		obj = servicoRepository.save(newServ);
		return obj;	
	}*/
	
	public Servico fromDTO(ServicoDTO objDto) {
		LocalDate data = LocalDate.parse(objDto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer clienteID = objDto.getClienteId();
		Cliente newObj = clienteService.findId(clienteID);
		
		Servico servico = new Servico();
		servico.setDescricao(objDto.getDescricao());
		servico.setData(data);
		servico.setCliente(newObj);
		servico.setPreco(bigDecimalConvert.convert(objDto.getPreco()));
		return servico;

	}
	
	public List<Servico> findAll (String nome, Integer mes){
		List<Servico> list = servicoRepository.findByNomeClienteAndMes(nome , mes);
		return list;
	}
	
	
	
	
}
