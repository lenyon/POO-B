package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.enums.TipoStatus;
import br.fatec.HelpDesk.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

public List<Ticket> findAllWithoutConclusion(){
    List<Ticket> tickets = findAll();

    tickets.stream()
            .filter(ticket -> ticket.getUltimoStatus().getStatus().equals(TipoStatus.CONCLUIDO))
            .forEach(tickets::remove);
    return tickets;
}
    public List<Ticket> findAllTicketsByTeam(Long id){
        List<Ticket> tickets = findAll();
        List<Ticket> teamTickets = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if(ticket.getEquipe().getId().equals(id)){
                teamTickets.add(ticket);
            }
        }
        return teamTickets;
    }

}
