package br.fatec.HelpDesk.controllers;


import br.fatec.HelpDesk.contexts.usuarioEquipe.UsuarioEquipeDTO;
import br.fatec.HelpDesk.dtos.CategoriaDTO;
import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.dtos.UsuarioDTO;
import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.mappers.MapperGeral;
import br.fatec.HelpDesk.services.CategoriaService;
import br.fatec.HelpDesk.services.PerfilService;
import br.fatec.HelpDesk.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/add/{senha}")
    public @ResponseBody ResponseEntity<UsuarioDTO> cadastrar(@PathVariable String senha,
                                                              @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioDTO.toUsuario(usuarioDTO);
        usuario.setSenha(senha);
        Usuario novoUsuario = usuarioService.cadastrar(usuario);

        return ResponseEntity.ok().body(UsuarioDTO.valueof(usuario));
    }

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<UsuarioDTO>> all() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(MapperGeral.mapListUsuarioToDTO(usuarios));
    }

    @PutMapping("/mudarSenha/{email}/{senhaAtual}/{novaSenha}")
    public @ResponseBody ResponseEntity<UsuarioDTO> mudarSenha(@PathVariable String email,
                                                               @PathVariable String senhaAtual,
                                                               @PathVariable String novaSenha
    ) {
        Usuario usuario = usuarioService.mudarSenha(email,senhaAtual,novaSenha);
        return ResponseEntity.ok().body(UsuarioDTO.valueof(usuario));

    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<List<UsuarioDTO>> deletarUsuario (@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        List<Usuario> usuarios = usuarioService.findAll();
        return  ResponseEntity.ok().body(MapperGeral.mapListUsuarioToDTO(usuarios));
    }


    @GetMapping("/find/{id}")
    public @ResponseBody ResponseEntity<UsuarioDTO> findById (
            @PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(UsuarioDTO.valueof(usuario));
    }
}
