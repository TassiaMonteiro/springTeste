package br.com.despachante.despachante_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.despachante.despachante_api.modelo.Nivel;

public interface NivelRepository extends JpaRepository<Nivel, Long> {

	Nivel findByNome(String nome);

}
