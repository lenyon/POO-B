package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Optional<List<Usuario>> findByCargo(String cargo);

}
