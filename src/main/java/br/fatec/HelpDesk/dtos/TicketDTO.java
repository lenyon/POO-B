package br.fatec.HelpDesk.dtos;

import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Status;
import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.entities.Usuario;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record TicketDTO (
        Long id,
        LocalDateTime dataAbertura,
        LocalDateTime dataConclusao,
        String descricao,
        String relatorioInterno,
        String titulo,
        Equipe equipe,
        Usuario solicitante,
        Status ultimoStatus
) implements Serializable {

    @Serial
    public static final long serialVersionUID = 1341344314134125L;

    public static TicketDTO valueOf(Ticket ticket){
        if (ticket != null){
            return new TicketDTO(
                    ticket.getId(),
                    ticket.getDataAbertura(),
                    ticket.getDataConclusao(),
                    ticket.getDescricao(),
                    ticket.getRelatorioInterno(),
                    ticket.getTitulo(),
                    ticket.getEquipe(),
                    ticket.getSolicitante(),
                    ticket.getUltimoStatus()
            );
        }
        return null;
    }

    public static List<TicketDTO> valueAll(List<Ticket> tickets){
        if(tickets != null && !tickets.isEmpty()){
            List<TicketDTO> dtos = new ArrayList<>();
            tickets.forEach(ticket -> {
                dtos.add(valueOf(ticket));
            });
            return dtos;
        } else return null;
    }

}