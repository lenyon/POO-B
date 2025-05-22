package br.fatec.HelpDesk.controllers;


import br.fatec.HelpDesk.dtos.CategoriaDTO;
import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/add/{servico}")
    public @ResponseBody ResponseEntity<CategoriaDTO> cadastrar(@PathVariable String servico) {
        Categoria categoria = categoriaService.cadastrar(servico);
        return ResponseEntity.ok().body(CategoriaDTO.valueof(categoria));
    }



}
