package com.celiosato.cliente.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.celiosato.cliente.domain.Servico;
import com.celiosato.cliente.dto.ServicoDTO;
import com.celiosato.cliente.services.ServicoService;

@RestController
@RequestMapping("/servicos")
//@CrossOrigin("http://localhost:4200")
public class ServicoResource {
	
	@Autowired
	private ServicoService servicoService;
	
	/*@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ServicoRepository servicoRepository;*/
	
	/*@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico insert(@RequestBody @Valid Servico obj) {
		obj = servicoService.insert(obj);
		return obj;
	}*/
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico insert(@RequestBody @Valid ServicoDTO objDto) {
		Servico obj = servicoService.fromDTO(objDto);
		obj = servicoService.insert(obj);
		return obj;
	}
	
  /*@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto){
		Cliente obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}*/
	
	@GetMapping
	public List<Servico> findAll(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
								 @RequestParam(value = "mes", required = false) Integer  mes){
		List<Servico> list = servicoService.findAll(nome,  mes);
		return list;
	}
	
	/*@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico insert(@RequestBody ServicoDTO objDto) {
		LocalDate data = LocalDate.parse(objDto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		String valor = objDto.getPreco();
		valor.replaceAll(",", ".");
		double vlConvertido = Double.parseDouble(valor);
		
		Cliente newObj = clienteService.findId(objDto.getClienteId());
		Servico servico = new Servico();
		servico.setDescricao(objDto.getDescricao());
		servico.setData(data);
		servico.setCliente(newObj);
		servico.setPreco(vlConvertido);
		return servicoRepository.save(servico);
	}*/
	
}
