package br.fatec.HelpDesk.mappers;


import br.fatec.HelpDesk.dtos.CategoriaDTO;
import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Perfil;

import java.io.Serial;
import java.io.Serializable;

public class MapperGeral implements Serializable {

    @Serial
    public static final long serialVersionUID = 8747284628421767781L;

    public static CategoriaDTO mapCategoriaToDTO(Categoria categoria) {
        return categoria != null
                ? CategoriaDTO.valueOf(categoria)
                : null;
    }

    public static Categoria mapDTOtoCategoria(CategoriaDTO dto) {
        return dto != null ? CategoriaDTO.toCategoria(dto) : null;
    }

    public static EquipeDTO mapEquipeToDTO(Equipe equipe) {
        return equipe != null
                ? EquipeDTO.valueOf(equipe)
                : null;
    }

    public static Equipe mapDTOtoEquipe(EquipeDTO dto) {
        return dto != null ? EquipeDTO.toEquipe(dto) : null;
    }

    public static PerfilDTO mapPerfilToDTO(Perfil perfil) {
        return perfil != null
                ? PerfilDTO.valueOf(perfil)
                : null;
    }

    public static Perfil mapDtoToPerfil (PerfilDTO dto) {
        return dto != null
                ? PerfilDTO.toPerfil(dto)
                : null;
    }

}
