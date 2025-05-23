package br.fatec.HelpDesk.contexts.usuarioEquipe;

import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.repositories.UsuarioRepository;
import br.fatec.HelpDesk.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioEquipeService {

    @Autowired
    UsuarioService usuarioService;

    public Usuario addEquipes(String email, List<EquipeDTO> dto){
       Usuario usuario = usuarioService.findByEmail(email);
       if (usuario != null && dto != null) {
           List<Equipe> equipes = new ArrayList<>();
           dto.forEach(equipe -> equipes.add(EquipeDTO.toEquipe(equipe)));
           usuario.setEquipes(equipes);
           return usuarioService.cadastrar(usuario);
       }
       return null;
    }

    public Usuario findByEmail(String email) {
        return usuarioService.findByEmail(email);
    }

}
