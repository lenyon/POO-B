package br.fatec.HelpDesk.dtos;

import br.fatec.HelpDesk.entities.Perfil;

import java.io.Serial;
import java.io.Serializable;

public record PerfilDTO(

        Long id,
        String nomePerfil

) implements Serializable {

    @Serial
    public static final long serialVersionUID = -123234235235L;

    public static PerfilDTO valueof(Perfil perfil) {
        if (perfil != null) {
            return new PerfilDTO(
                perfil.getId(),
                perfil.getPerfil()
            );
        }
        return null;
    }

    public static Perfil toPerfil(PerfilDTO perfilDTO) {
        if (perfilDTO != null){
            Perfil perfil = new Perfil();
            perfil.setId(perfilDTO.id);
            perfil.setPerfil(perfilDTO.nomePerfil);
            return perfil;
        }
        return  null;
    }

}
