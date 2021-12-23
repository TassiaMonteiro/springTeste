package br.com.despachante.despachante_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.despachante.despachante_api.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNome(String nome);

	Cliente findByClienteId(Long clienteId);

}
