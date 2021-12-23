package br.com.despachante.despachante_api.controller.form;

import br.com.despachante.despachante_api.modelo.Cliente;
import br.com.despachante.despachante_api.modelo.Veiculo;
import br.com.despachante.despachante_api.repository.ClienteRepository;
import br.com.despachante.despachante_api.repository.VeiculoRepository;

public class VeiculoForm {

	private String placa;
	private String marca;
	private Integer ano;
	private String chassi;
	private String tipo;
	private String modelo;
	private String cor;
	private String cidade;
	private String renavam;
	private String observacoes;
	private Long clienteId;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Veiculo converter(ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.findByClienteId(clienteId);
		return new Veiculo(placa, marca, ano, chassi, tipo, modelo, cor, cidade, renavam, observacoes, cliente);
	}

	public Veiculo editar(Long id, VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
		Veiculo veiculo = veiculoRepository.getOne(id);
		Cliente cliente = clienteRepository.findByClienteId(clienteId);
		if (this.placa != null) {
			veiculo.setPlaca(this.placa);
		}
		if (this.marca != null) {
			veiculo.setMarca(this.marca);
		}
		if (this.ano != null) {
			veiculo.setAno(this.ano);
		}
		if (chassi != null) {
			veiculo.setChassi(chassi);
		}
		if (this.tipo != null) {
			veiculo.setTipo(this.tipo);
		}
		if (this.modelo != null) {
			veiculo.setModelo(this.modelo);
		}
		if (cor != null) {
			veiculo.setCor(cor);
		}
		if (cidade != null) {
			veiculo.setCidade(cidade);
		}
		if (renavam != null) {
			veiculo.setRenavam(renavam);
		}
		if (observacoes != null) {
			veiculo.setObservacoes(observacoes);
		}
		if (cliente != null) {
			veiculo.setCliente(cliente);
		}
		
		return veiculo;
	}

}
