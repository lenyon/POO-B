package br.fatec.HelpDesk.contexts.abrirTicket;

import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Status;
import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.enums.TipoStatus;
import br.fatec.HelpDesk.repositories.TicketRepository;
import br.fatec.HelpDesk.services.EquipeService;
import br.fatec.HelpDesk.services.TicketService;
import br.fatec.HelpDesk.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AbrirTicketService {

    @Autowired
    TicketService ticketService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EquipeService equipeService;


    public Ticket abrirTicket (AbrirTicketDTO dto) {
        Usuario solicitante = usuarioService.findById(dto.id_usuario());
        Equipe equipe = equipeService.findById(dto.id_equipe());

        if(solicitante !=null && equipe != null) {
            Ticket ticket = new Ticket();
            ticket.setSolicitante(solicitante);
            ticket.setEquipe(equipe);
            ticket.setTitulo(dto.titulo());
            ticket.setDescricao(dto.descricao());
            ticket.setDataAbertura(LocalDateTime.now());

            Status status = new Status(TipoStatus.AGUARDANDO_ATENDIMENTO);
            ticket.setUltimoStatus(status);

            return ticketService.salvar(ticket);
        }
        return null;
    }
}
