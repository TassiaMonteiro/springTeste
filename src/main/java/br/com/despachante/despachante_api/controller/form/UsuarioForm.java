package br.com.despachante.despachante_api.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.despachante.despachante_api.modelo.Nivel;
import br.com.despachante.despachante_api.modelo.Usuario;
import br.com.despachante.despachante_api.repository.NivelRepository;
import br.com.despachante.despachante_api.repository.UsuarioRepository;

public class UsuarioForm {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String login;
	@NotNull @NotEmpty
	private String email;
	@NotNull @NotEmpty
	private String nomeNivel;
	@NotNull @NotEmpty
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeNivel() {
		return nomeNivel;
	}

	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario converter(NivelRepository nivelRepository) {
		Nivel nivel = nivelRepository.findByNome(nomeNivel);
		this.senha = new BCryptPasswordEncoder().encode(senha);
		return new Usuario(nome, login, email, nivel, senha);
	}

	public Usuario editar(Long id, UsuarioRepository usuarioRepository, NivelRepository nivelRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		Nivel nivel = nivelRepository.findByNome(nomeNivel);
		if (this.nome != null) {
			usuario.setNome(this.nome);
		}
		if (this.login != null) {
			usuario.setLogin(this.login);
		}
		if (this.email != null) {
			usuario.setEmail(this.email);
		}
		if (nivel != null) {
			usuario.setNivel(nivel);
		}
		return usuario;
	}

}
