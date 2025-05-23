package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}
