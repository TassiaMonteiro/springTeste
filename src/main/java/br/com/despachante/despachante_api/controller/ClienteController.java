package br.com.despachante.despachante_api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

import br.com.despachante.despachante_api.controller.form.ClienteForm;
import br.com.despachante.despachante_api.modelo.Cliente;
import br.com.despachante.despachante_api.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listarCliente(String nome) {
		if (nome == null) {
			List<Cliente> clientes = clienteRepository.findAll();
			return clientes;
		} else {
			List<Cliente> clientes = clienteRepository.findByNome(nome);
			return clientes;
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
		Cliente cliente = clienteForm.converter();
		clienteRepository.save(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getClienteId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> detalharCliente(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Cliente> editarCliente(@PathVariable Long id, @RequestBody ClienteForm clienteForm){
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			Cliente cliente = clienteForm.editar(id, clienteRepository);
			return ResponseEntity.ok(cliente);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerCliente(@PathVariable Long id){
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
		
}
