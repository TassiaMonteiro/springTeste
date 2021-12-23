package br.com.despachante.despachante_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.despachante.despachante_api.modelo.Protocolo;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long>  {

	List<Protocolo> findByVeiculoPlaca(String placa);

	List<Protocolo> findByVeiculoClienteNome(String nomeCliente);

	List<Protocolo> findByIsConcluido(Boolean isConcluido);

	@Query("SELECT p FROM Protocolo p WHERE p.veiculo.placa = ?1 and p.veiculo.cliente.nome = ?2")
	List<Protocolo> findByPlacaNomeCliente(String placa, String nomeCliente);

	@Query("SELECT p FROM Protocolo p WHERE p.veiculo.cliente.nome = ?1 and p.isConcluido = ?2")
	List<Protocolo> findByClienteIsConcluido(String nomeCliente, Boolean isConcluido);

	@Query("SELECT p FROM Protocolo p WHERE p.veiculo.placa = ?1 and p.isConcluido = ?2")
	List<Protocolo> findByPlacaIsConcluido(String placa, Boolean isConcluido);

	@Query("SELECT p FROM Protocolo p WHERE p.veiculo.placa = ?1 and p.veiculo.cliente.nome = ?2 and p.isConcluido = ?3")
	List<Protocolo> findByPlacaClienteIsConcluido(String placa, String nomeCliente, Boolean isConcluido);

}
