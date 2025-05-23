package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

public List<Ticket> findAll() {
    return ticketRepository.findAll();
}

public Ticket findById(Long id) {
    return ticketRepository.findById(id).orElse(null);
}
@Transactional
public Ticket salvar (Ticket ticket) {
    if (ticket != null) {
        return ticketRepository.save(ticket);
    }
    return  null;
}


}
