package br.com.despachante.despachante_api.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.despachante.despachante_api.modelo.Protocolo;
import br.com.despachante.despachante_api.modelo.Usuario;
import br.com.despachante.despachante_api.modelo.Veiculo;
import br.com.despachante.despachante_api.repository.ProtocoloRepository;
import br.com.despachante.despachante_api.repository.UsuarioRepository;
import br.com.despachante.despachante_api.repository.VeiculoRepository;

public class ProtocoloForm {

	@NotNull @NotEmpty
	private String servicos;
	@NotNull
	private BigDecimal valorRecebido;
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE_TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private LocalDate dataAquisicao;
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE_TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private LocalDate dataRegistro;
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE_TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private LocalDate dataEntrega;
	@NotNull @NotEmpty
	private String nomeVendedor;
	@NotNull @NotEmpty
	private String documentoVendedor;
	private String observacoes;
	@NotNull
	private Long veiculoId;
	@NotNull
	private Long usuarioId;
	
	private Boolean isConcluido;

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

	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public Boolean getIsConcluido() {
		return isConcluido;
	}

	public void setIsConcluido(Boolean isConcluido) {
		this.isConcluido = isConcluido;
	}

	public Protocolo converter(VeiculoRepository veiculoRepository, UsuarioRepository usuarioRepository) {
		Veiculo veiculo = veiculoRepository.findByVeiculoId(veiculoId);
		Usuario usuario = usuarioRepository.findByUsuarioId(usuarioId);
		return new Protocolo(servicos, valorRecebido, dataAquisicao, dataRegistro, dataEntrega, nomeVendedor, documentoVendedor, observacoes, veiculo, usuario);
	}

	public Protocolo editar(Long id, ProtocoloRepository protocoloRepository) {
		Protocolo protocolo = protocoloRepository.getOne(id);
		if (this.servicos != null) {
			protocolo.setServicos(this.servicos);
		}
		if (this.valorRecebido != null) {
			protocolo.setValorRecebido(this.valorRecebido);
		}
		if (this.dataAquisicao != null) {
			protocolo.setDataAquisicao(this.dataAquisicao);
		}
		if (dataRegistro != null) {
			protocolo.setDataRegistro(dataRegistro);
		}
		if (this.dataEntrega != null) {
			protocolo.setDataEntrega(this.dataEntrega);
		}
		if (this.valorRecebido != null) {
			protocolo.setValorRecebido(this.valorRecebido);
		}
		if (nomeVendedor != null) {
			protocolo.setNomeVendedor(nomeVendedor);
		}
		if (this.documentoVendedor != null) {
			protocolo.setDocumentoVendedor(this.documentoVendedor);
		}
		if (this.observacoes != null) {
			protocolo.setObservacoes(this.observacoes);
		}
		
		if(this.isConcluido != null) {
			protocolo.setIsConcluido(this.isConcluido);
		}
		
		return protocolo;
	}

}
