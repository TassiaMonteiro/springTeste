package br.com.despachante.despachante_api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.despachante.despachante_api.controller.dto.UsuarioDto;
import br.com.despachante.despachante_api.controller.form.UsuarioForm;
import br.com.despachante.despachante_api.modelo.Usuario;
import br.com.despachante.despachante_api.repository.NivelRepository;
import br.com.despachante.despachante_api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private NivelRepository nivelRepository;

	@GetMapping
	public List<UsuarioDto> listarUsuario(String nome) {
		if (nome == null) {
			List<Usuario> usuarios = usuarioRepository.findAll();	
			return UsuarioDto.converter(usuarios);
		}else {
			List<Usuario> usuarios = usuarioRepository.findByNome(nome);	
			return UsuarioDto.converter(usuarios);
		}
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder) {
		Usuario usuario = usuarioForm.converter(nivelRepository);
		usuarioRepository.save(usuario);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getUsuarioId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> detalharUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(usuario.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> editarUsuario(@PathVariable Long id, @RequestBody UsuarioForm usuarioForm){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			Usuario usuario = usuarioForm.editar(id, usuarioRepository, nivelRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerUsuario(@PathVariable Long id){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
			
}

















