package br.com.despachante.despachante_api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.despachante.despachante_api.modelo.Veiculo;
import br.com.despachante.despachante_api.utils.DateUtils;

public class VeiculoDto {

	private Long veiculoId;
	private String dataDeCadastro;
	private String placa;
	private String marca;
	private int ano;
	private String chassi;
	private String tipo;
	private String modelo;
	private String cor;
	private String cidade;
	private String renavam;
	private String observacoes;
	private Long clienteId;
	private String nomeCliente;
	private String documentoCliente;

	public VeiculoDto(Veiculo veiculo) {
		this.veiculoId = veiculo.getVeiculoId();
		this.dataDeCadastro = DateUtils.converterDataPadraoBR(veiculo.getDataDeCadastro());
		this.placa = veiculo.getPlaca();
		this.marca = veiculo.getMarca();
		this.ano = veiculo.getAno();
		this.chassi = veiculo.getChassi();
		this.tipo = veiculo.getTipo();
		this.modelo = veiculo.getModelo();
		this.cor = veiculo.getCor();
		this.cidade = veiculo.getCidade();
		this.renavam = veiculo.getRenavam();
		this.observacoes = veiculo.getObservacoes();
		this.clienteId = veiculo.getCliente().getClienteId();
		this.nomeCliente = veiculo.getCliente().getNome();
		this.documentoCliente = veiculo.getCliente().getDocumento();
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public String getDataDeCadastro() {
		return dataDeCadastro;
	}

	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public int getAno() {
		return ano;
	}

	public String getChassi() {
		return chassi;
	}

	public String getTipo() {
		return tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public String getCidade() {
		return cidade;
	}

	public String getRenavam() {
		return renavam;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public static List<VeiculoDto> converter(List<Veiculo> veiculos) {
		return veiculos.stream().map(VeiculoDto::new).collect(Collectors.toList());
	}

}
