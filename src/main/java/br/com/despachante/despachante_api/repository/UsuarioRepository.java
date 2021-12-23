package br.com.despachante.despachante_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.despachante.despachante_api.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNome(String nome);

	Usuario findByUsuarioId(Long usuarioId);
	
	Optional<Usuario> findByLogin(String login);

}
