package br.com.despachante.despachante_api.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.despachante.despachante_api.modelo.Cliente;
import br.com.despachante.despachante_api.repository.ClienteRepository;

public class ClienteForm {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String documento;
	@NotNull @NotEmpty
	private String rg;
	@NotNull @NotEmpty
	private String endereco;
	@NotNull @NotEmpty
	private String bairro;
	@NotNull @NotEmpty
	private String cidade;
	private String celular;
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente converter() {
		return new Cliente(nome, documento, rg, endereco, bairro, cidade, celular, telefone);
	}

	public Cliente editar(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		if (this.nome != null) {
			cliente.setNome(this.nome);
		}
		if (this.documento != null) {
			cliente.setDocumento(this.documento);
		}
		if (this.rg != null) {
			cliente.setRg(this.rg);
		}
		if (endereco != null) {
			cliente.setEndereco(endereco);
		}
		if (this.bairro != null) {
			cliente.setBairro(this.bairro);
		}
		if (this.cidade != null) {
			cliente.setCidade(this.cidade);
		}
		if (celular != null) {
			cliente.setCelular(celular);
		}
		if (telefone != null) {
			cliente.setTelefone(telefone);
		}
		return cliente;
	}

}
