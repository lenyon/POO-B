package br.fatec.HelpDesk.contexts.usuarioEquipe;

import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.entities.UsuarioEquipe;
import br.fatec.HelpDesk.repositories.UsuarioEquipeRepository;
import br.fatec.HelpDesk.services.EquipeService;
import br.fatec.HelpDesk.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UsuarioEquipeService {

    @Autowired
    EquipeService equipeService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioEquipeRepository usuarioEquipeRepository;

    public Usuario addEquipes(String email, List<EquipeDTO> dto) {
        Usuario usuario = usuarioService.findByEmail(email);
        if (usuario == null || dto == null) {
            throw new RuntimeException("Usuario não existe no banco.");
        }

        List<Long> equipeIds = dto.stream()
                .map(EquipeDTO::id)
                .filter(Objects::nonNull)
                .toList();

        List<Equipe> equipesPersistidas = equipeService.findAllById(equipeIds);
        List<UsuarioEquipe> usuarioEquipesAtuais = usuarioEquipeRepository.findByUsuario(usuario);

        // Remover antigas
        usuarioEquipesAtuais.stream()
                .filter(ue -> equipesPersistidas.stream().noneMatch(
                        eq -> eq.getId().equals(ue.getEquipe().getId())))
                .forEach(ue -> {
                            ue.setAtivo(false);
                            usuarioEquipeRepository.save(ue);

                        });



        // Adicionar novas
        for (Equipe equipe : equipesPersistidas) {
            boolean jaExiste = false;

            for (UsuarioEquipe ue : usuarioEquipesAtuais) {
                if (ue.getEquipe().getId().equals(equipe.getId())) {
                    jaExiste = true;
                    if (!ue.isAtivo()) {
                        ue.setAtivo(true);
                        usuarioEquipeRepository.save(ue);
                    }
                    break;
                }
            }

            if (!jaExiste) {
                UsuarioEquipe nova = new UsuarioEquipe();
                nova.setUsuario(usuario);
                nova.setEquipe(equipe);
                nova.setAtivo(true);
                usuarioEquipeRepository.save(nova);
            }
        }

        return usuarioService.findByEmail(email);
    }


    public Usuario findByEmail(String email) {
        return usuarioService.findByEmail(email);
    }

}
