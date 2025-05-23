package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
