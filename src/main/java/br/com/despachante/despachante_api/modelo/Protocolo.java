package br.com.despachante.despachante_api.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Protocolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long protocoloId;
	private String servicos;
	private BigDecimal valorRecebido;
	private LocalDate dataAquisicao;
	private LocalDate dataRegistro;
	private LocalDate dataEntrega;
	private String nomeVendedor;
	private String documentoVendedor;
	private String observacoes;
	@ManyToOne
	private Veiculo veiculo;
	@ManyToOne
	private Usuario usuario;
	
	private Boolean isConcluido;
	
	public Protocolo() {
	}
	
	public Protocolo(String servicos, BigDecimal valorRecebido, LocalDate dataAquisicao, LocalDate dataRegistro,
			LocalDate dataEntrega, String nomeVendedor, String documentoVendedor, String observacoes,
			Veiculo veiculo, Usuario usuario) {
		this.servicos = servicos;
		this.valorRecebido = valorRecebido;
		this.dataAquisicao = dataAquisicao;
		this.dataRegistro = dataRegistro;
		this.dataEntrega = dataEntrega;
		this.nomeVendedor = nomeVendedor;
		this.documentoVendedor = documentoVendedor;
		this.observacoes = observacoes;
		this.veiculo = veiculo;
		this.usuario = usuario;
		this.isConcluido = false;
	}

	public Long getProtocoloId() {
		return protocoloId;
	}
	public void setProtocoloId(Long protocoloId) {
		this.protocoloId = protocoloId;
	}
	public String getServicos() {
		return servicos;
	}
	public void setServicos(String servicos) {
		this.servicos = servicos;
	}
	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}
	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}
	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	public LocalDate getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public String getDocumentoVendedor() {
		return documentoVendedor;
	}
	public void setDocumentoVendedor(String documentoVendedor) {
		this.documentoVendedor = documentoVendedor;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getIsConcluido() {
		return isConcluido == null ? false : isConcluido;
	}

	public void setIsConcluido(Boolean isConcluido) {
		this.isConcluido = isConcluido;
	}
	
	
}
