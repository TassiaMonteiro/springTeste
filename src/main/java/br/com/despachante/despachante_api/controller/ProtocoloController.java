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

import br.com.despachante.despachante_api.controller.dto.ProtocoloDto;
import br.com.despachante.despachante_api.controller.form.ProtocoloForm;
import br.com.despachante.despachante_api.modelo.Protocolo;
import br.com.despachante.despachante_api.repository.ProtocoloRepository;
import br.com.despachante.despachante_api.repository.UsuarioRepository;
import br.com.despachante.despachante_api.repository.VeiculoRepository;

@RestController
@RequestMapping("/protocolo")
public class ProtocoloController {

	@Autowired
	private ProtocoloRepository protocoloRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<ProtocoloDto> listarProtocolo(String placa, String nomeCliente, Boolean isConcluido) {
		List<Protocolo> protocolos = null;
		
		if (placa == null && nomeCliente == null && isConcluido == null) {
			 protocolos = protocoloRepository.findAll();
		
		} else if(placa != null && nomeCliente == null && isConcluido == null) {
			protocolos = protocoloRepository.findByVeiculoPlaca(placa);
		
		} else if(placa == null && nomeCliente != null && isConcluido == null) {
			protocolos = protocoloRepository.findByVeiculoClienteNome(nomeCliente);
		
		} else if(placa == null && nomeCliente == null && isConcluido != null) {
			protocolos = protocoloRepository.findByIsConcluido(isConcluido);
		
		} else if(placa != null && nomeCliente != null && isConcluido == null) {
			protocolos = protocoloRepository.findByPlacaNomeCliente(placa, nomeCliente);
		
		} else if(placa != null && nomeCliente == null && isConcluido != null) {
			protocolos = protocoloRepository.findByPlacaIsConcluido(placa, isConcluido);
		
		} else if(placa == null && nomeCliente != null && isConcluido != null) {
			protocolos = protocoloRepository.findByClienteIsConcluido(nomeCliente, isConcluido);
		
		} else if(placa != null && nomeCliente != null && isConcluido != null) {
			protocolos = protocoloRepository.findByPlacaClienteIsConcluido(placa, nomeCliente, isConcluido);
		}
				
		return ProtocoloDto.converter(protocolos);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ProtocoloDto> cadastrarProtocolo(@RequestBody ProtocoloForm protocoloForm,
			UriComponentsBuilder uriBuilder) {
		Protocolo protocolo = protocoloForm.converter(veiculoRepository, usuarioRepository);
		protocoloRepository.save(protocolo);
		URI uri = uriBuilder.path("/protocolo/{id}").buildAndExpand(protocolo.getProtocoloId()).toUri();
		return ResponseEntity.created(uri).body(new ProtocoloDto(protocolo));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProtocoloDto> detalharProtocolo(@PathVariable Long id) {
		Optional<Protocolo> protocolo = protocoloRepository.findById(id);
		if (protocolo.isPresent()) {
			return ResponseEntity.ok(new ProtocoloDto(protocolo.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProtocoloDto> editarProtocolo(@PathVariable Long id,
			@RequestBody ProtocoloForm protocoloForm) {
		Optional<Protocolo> optional = protocoloRepository.findById(id);
		if (optional.isPresent()) {
			Protocolo protocolo = protocoloForm.editar(id, protocoloRepository);
			return ResponseEntity.ok(new ProtocoloDto(protocolo));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerProtocolo(@PathVariable Long id) {
		Optional<Protocolo> optional = protocoloRepository.findById(id);
		if (optional.isPresent()) {
			protocoloRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
