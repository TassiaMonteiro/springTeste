package br.com.despachante.despachante_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.despachante.despachante_api.modelo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findByPlaca(String placa);

	Veiculo findByVeiculoId(Long veiculoId);

	List<Veiculo> findByClienteNome(String nomeCliente);

	@Query("SELECT v FROM Veiculo v WHERE v.placa = ?1 and v.cliente.nome = ?2")
	List<Veiculo> findByPlacaClienteNome(String placa, String nomeCliente);

}
