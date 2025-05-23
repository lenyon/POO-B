package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    //SQL
    @Query (value = "SELECT * from Usuario WHERE email = :email", nativeQuery = true)
    Optional<Usuario> findByEmailSQL(String email);

    //HQL
    @Query (value = "SELECT usu FROM Usuario usu WHERE usu.email = :email", nativeQuery = false)
    Optional<Usuario> findByEmail(String email);

}
