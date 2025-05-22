package br.fatec.HelpDesk.controllers;


import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.services.EquipeService;
import br.fatec.HelpDesk.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    EquipeService equipeService;

    @PostMapping("/add/{nomeEquipe}")
    public @ResponseBody ResponseEntity<EquipeDTO> cadastrar(@PathVariable String nomeEquipe) {
        Equipe equipe = equipeService.cadastrar(nomeEquipe);
        return ResponseEntity.ok().body(EquipeDTO.valueof(equipe));
    }



}
