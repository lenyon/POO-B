package br.fatec.HelpDesk.contexts.abrirTicket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/abrirTicket")
public class AbrirTicketController {

    @Autowired
    AbrirTicketService abrirTicketService;

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<Object> abrirTicket(@RequestBody AbrirTicketDTO dto) {
        if (dto != null) {
            if(abrirTicketService.abrirTicket(dto) != null) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }


}
