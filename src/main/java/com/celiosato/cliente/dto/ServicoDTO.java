package com.celiosato.cliente.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 150)
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotEmpty(message = "{campo.data.obrigatorio}")
	private String data;
	
	@Column(nullable = false, length = 10)
	@NotEmpty(message = "{campo.preco.obrigatorio}")
	private String preco;
	
	@NotNull(message = "{campo.nome.obrigatorio}")
	private Integer clienteId;
	
	public ServicoDTO() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

}
