package br.com.despachante.despachante_api.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nivel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nivelId;
	private String nome;

	public Long getNivelId() {
		return nivelId;
	}

	public void setNivelId(Long nivelId) {
		this.nivelId = nivelId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
