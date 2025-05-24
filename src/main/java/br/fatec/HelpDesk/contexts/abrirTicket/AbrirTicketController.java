package br.fatec.HelpDesk.contexts.abrirTicket;


import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.dtos.TicketDTO;
import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/abrirTicket")
public class AbrirTicketController {

    @Autowired
    AbrirTicketService abrirTicketService;

    @Autowired
    TicketService ticketService;

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<Object> abrirTicket(@RequestBody @Valid AbrirTicketDTO dto) {
        if (dto != null) {
            if(abrirTicketService.abrirTicket(dto) != null) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @GetMapping("/OpenedWithoutConclusion")
    public @ResponseBody ResponseEntity <List<TicketDTO>> OpenedWithoutConclusion () {
        List<Ticket> tickets = ticketService.findAllWithoutConclusion();
        return ResponseEntity.ok().body(TicketDTO.valueAll(tickets));
    }

    @GetMapping("/allTicketsByTeam/{id}")
    public @ResponseBody ResponseEntity<List<TicketDTO>> findAllTicketsByTeam(@PathVariable Long id){
        List<Ticket> tickets = ticketService.findAllTicketsByTeam(id);
        return ResponseEntity.ok().body(TicketDTO.valueAll(tickets));
    }

}
