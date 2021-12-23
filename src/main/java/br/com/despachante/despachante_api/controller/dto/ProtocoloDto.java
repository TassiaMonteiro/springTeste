package br.com.despachante.despachante_api.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.despachante.despachante_api.modelo.Protocolo;
import br.com.despachante.despachante_api.utils.DateUtils;

public class ProtocoloDto {

	private Long protocoloId;
	private String servicos;
	private BigDecimal valorRecebido;
	private String dataAquisicao;
	private String dataRegistro;
	private String dataEntrega;
	private String nomeVendedor;
	private String documentoVendedor;
	private String observacoes;
	private Long veiculoId;
	private String placa;
	private Long clienteId;
	private String nomeCliente;
	private Long usuarioId;
	private String nomeUsuario;
	private Boolean isConcluido;

	public ProtocoloDto(Protocolo protocolo) {
		this.protocoloId = protocolo.getProtocoloId();
		this.servicos = protocolo.getServicos();
		this.valorRecebido = protocolo.getValorRecebido();
		this.dataAquisicao = DateUtils.converterDataPadraoBR(protocolo.getDataAquisicao());
		this.dataRegistro = DateUtils.converterDataPadraoBR(protocolo.getDataRegistro());
		this.dataEntrega = DateUtils.converterDataPadraoBR(protocolo.getDataEntrega());
		this.nomeVendedor = protocolo.getNomeVendedor();
		this.documentoVendedor = protocolo.getDocumentoVendedor();
		this.observacoes = protocolo.getObservacoes();
		this.veiculoId = protocolo.getVeiculo().getVeiculoId();
		this.placa = protocolo.getVeiculo().getPlaca();
		this.clienteId = protocolo.getVeiculo().getCliente().getClienteId();
		this.nomeCliente = protocolo.getVeiculo().getCliente().getNome();
		this.usuarioId = protocolo.getUsuario().getUsuarioId();
		this.nomeUsuario = protocolo.getUsuario().getNome();
		this.isConcluido = protocolo.getIsConcluido();
	}

	public Long getProtocoloId() {
		return protocoloId;
	}

	public String getServicos() {
		return servicos;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public String getDataAquisicao() {
		return dataAquisicao;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public String getDocumentoVendedor() {
		return documentoVendedor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public String getPlaca() {
		return placa;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public static List<ProtocoloDto> converter(List<Protocolo> protocolos) {
		return protocolos.stream().map(ProtocoloDto::new).collect(Collectors.toList());
	}

	public Boolean getIsConcluido() {
		return isConcluido;
	}
}
