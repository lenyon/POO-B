package br.fatec.HelpDesk.contexts.usuarioEquipe;

import br.fatec.HelpDesk.contexts.abrirTicket.AbrirTicketDTO;
import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.exceptions.GlobalExceptionHandler;
import br.fatec.HelpDesk.repositories.UsuarioRepository;
import br.fatec.HelpDesk.services.EquipeService;
import br.fatec.HelpDesk.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarioEquipe")
public class UsuarioEquipeController {

    @Autowired
    UsuarioEquipeService usuarioEquipeService;

    @Autowired
    EquipeService equipeService;

    @PostMapping("/add/{email}")
    public @ResponseBody ResponseEntity<UsuarioEquipeDTO> addEquipes (
            @PathVariable  String email ,
            @RequestBody @Valid List< EquipeDTO> dto) {

        Usuario usuario = usuarioEquipeService.addEquipes(email, dto);
            return ResponseEntity.ok().body(UsuarioEquipeDTO.valueof(usuario));
    }

    @GetMapping("/find/{email}")
    public @ResponseBody ResponseEntity<UsuarioEquipeDTO> findByEmail (
            @PathVariable String email) {
        Usuario usuario = usuarioEquipeService.findByEmail(email);
        return ResponseEntity.ok().body(UsuarioEquipeDTO.valueof(usuario));
    }

    @GetMapping("/allEquipes")
    public @ResponseBody ResponseEntity<List<EquipeDTO>> findAllEquipes () {
        List<Equipe> equipes = equipeService.findAll();
        return ResponseEntity.ok().body(EquipeDTO.valueAll(equipes));
    }
}
