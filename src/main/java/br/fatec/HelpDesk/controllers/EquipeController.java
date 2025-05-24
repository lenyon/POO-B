package br.fatec.HelpDesk.controllers;


import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.mappers.MapperGeral;
import br.fatec.HelpDesk.services.EquipeService;
import br.fatec.HelpDesk.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find/{id}")
    public @ResponseBody ResponseEntity<EquipeDTO> findById (
            @PathVariable Long id) {
        Equipe equipe = equipeService.findById(id);
        return ResponseEntity.ok().body(EquipeDTO.valueof(equipe));
    }

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<EquipeDTO>> all() {
        List<Equipe> listaEquipe = equipeService.findAll();
        return ResponseEntity.ok().body(MapperGeral.mapListEquipeToDTO(listaEquipe));
    }




}
