package br.fatec.HelpDesk.controllers;


import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    PerfilService perfilService;

    @PostMapping("/add/{nomePerfil}")
    public @ResponseBody ResponseEntity<PerfilDTO> cadastrar(@PathVariable String nomePerfil) {
        Perfil perf = perfilService.cadastrar(nomePerfil);
        return ResponseEntity.ok().body(PerfilDTO.valueof(perf));
    }

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<PerfilDTO>> all() {
        List<Perfil> listaPerfil = perfilService.findAll();
    }

}
