package br.com.despachante.despachante_api.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long veiculoId;
	private LocalDate dataDeCadastro = LocalDate.now();
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
	@ManyToOne
	private Cliente cliente;
	
	public Veiculo() {
	}

	public Veiculo(String placa, String marca, int ano, String chassi, String tipo, String modelo, String cor,
			String cidade, String renavam, String observacoes, Cliente cliente) {
		this.placa = placa;
		this.marca = marca;
		this.ano = ano;
		this.chassi = chassi;
		this.tipo = tipo;
		this.modelo = modelo;
		this.cor = cor;
		this.cidade = cidade;
		this.renavam = renavam;
		this.observacoes = observacoes;
		this.cliente = cliente;
	}

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
