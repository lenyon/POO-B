package br.fatec.HelpDesk.controllers;


import br.fatec.HelpDesk.dtos.CategoriaDTO;
import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.dtos.UsuarioDTO;
import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.services.CategoriaService;
import br.fatec.HelpDesk.services.PerfilService;
import br.fatec.HelpDesk.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.cadastrar(UsuarioDTO.toUsuario(usuarioDTO));
        return ResponseEntity.ok().body(UsuarioDTO.valueof(usuario));
    }



}
