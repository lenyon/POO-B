package br.fatec.HelpDesk.contexts.usuarioEquipe;

import br.fatec.HelpDesk.dtos.UsuarioDTO;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.entities.UsuarioEquipe;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public record UsuarioEquipeDTO(
        String nome,
        String email,
        String perfil,
        List<String> equipes
) implements Serializable {

    @Serial
    public static final long serialVersionUID = 12442453463554L;

    public static UsuarioEquipeDTO valueof(Usuario usuario) {
        if (usuario != null) {

            List<String> equipes = new ArrayList<>();
            if (usuario.getEquipes() != null && !usuario.getEquipes().isEmpty())
                usuario.getEquipes().forEach(equipe -> equipes.add(equipe.getEquipe()));

            return  new UsuarioEquipeDTO(
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getPerfil().getPerfil(),
                    equipes
            );
        }
        return null;
    }


}
