package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository  extends JpaRepository<Perfil, Long> {

}
