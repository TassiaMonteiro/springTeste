package br.com.despachante.despachante_api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.despachante.despachante_api.modelo.Nivel;
import br.com.despachante.despachante_api.modelo.Usuario;
import br.com.despachante.despachante_api.utils.DateUtils;

public class UsuarioDto {

	private Long usuarioId;
	private String nome;
	private String login;
	private String email;
	private String dataDeCadastro;
	private Nivel nivel;
	
	public UsuarioDto(Usuario usuario) {
		this.usuarioId=usuario.getUsuarioId();
		this.nome=usuario.getNome();
		this.login=usuario.getLogin();
		this.email=usuario.getEmail();
		this.dataDeCadastro= DateUtils.converterDataPadraoBR(usuario.getDataDeCadastro());
		this.nivel=usuario.getNivel();
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getDataDeCadastro() {
		return dataDeCadastro;
	}
	
	public Nivel getNivel() {
		return nivel;
	}

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}
