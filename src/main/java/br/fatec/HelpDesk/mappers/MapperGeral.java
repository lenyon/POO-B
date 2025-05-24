package br.fatec.HelpDesk.mappers;


import br.fatec.HelpDesk.dtos.CategoriaDTO;
import br.fatec.HelpDesk.dtos.EquipeDTO;
import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.dtos.UsuarioDTO;
import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.entities.Usuario;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MapperGeral implements Serializable {

    @Serial
    public static final long serialVersionUID = 8747284628421767781L;

    public static CategoriaDTO mapCategoriaToDTO(Categoria categoria) {
        return categoria != null
                ? CategoriaDTO.valueof(categoria)
                : null;
    }

    public static Categoria mapDTOtoCategoria(CategoriaDTO dto) {
        return dto != null ? CategoriaDTO.toCategoria(dto) : null;
    }

    public static EquipeDTO mapEquipeToDTO(Equipe equipe) {
        return equipe != null
                ? EquipeDTO.valueof(equipe)
                : null;
    }

    public static Equipe mapDTOtoEquipe(EquipeDTO dto) {
        return dto != null ? EquipeDTO.toEquipe(dto) : null;
    }

    public static List<EquipeDTO> mapListEquipeToDTO (List<Equipe> listaEquipes) {
        if (listaEquipes != null && !listaEquipes.isEmpty()) {
            List<EquipeDTO> dtos = new ArrayList<>();
            listaEquipes.forEach(equipe -> dtos.add(EquipeDTO.valueof(equipe)));
            return dtos;
        }
        return null;
    }


    public static PerfilDTO mapPerfilToDTO(Perfil perfil) {
        return perfil != null
                ? PerfilDTO.valueof(perfil) : null;
    }

    public static Perfil mapDtoToPerfil (PerfilDTO dto) {
        return dto != null
                ? PerfilDTO.toPerfil(dto)
                : null;
    }

    public static List<PerfilDTO> mapListPerfiltoDTO(List<Perfil> listaPerfil) {
        if (listaPerfil != null && !listaPerfil.isEmpty()) {
            List<PerfilDTO> dtos = new ArrayList<>();
            listaPerfil.forEach(perfil -> {
                PerfilDTO dto = PerfilDTO.valueof(perfil);
                dtos.add(dto);
            });
            return dtos;
        }
        return null;
    }

    public static UsuarioDTO mapUsuarioToDTO (Usuario usuario) {
        return usuario !=null
                ? UsuarioDTO.valueof(usuario) : null;
    }

    public static Usuario mapDTOToUsuario (UsuarioDTO dto) {
        return  dto != null ? UsuarioDTO.toUsuario(dto) : null;
    }

    public static List<UsuarioDTO> mapListUsuarioToDTO (List<Usuario> usuarios) {
        if (usuarios != null && !usuarios.isEmpty()) {
            List<UsuarioDTO> dtos = new ArrayList<>();
            usuarios.forEach(usuario -> dtos.add(UsuarioDTO.valueof(usuario)));
            return dtos;
        }
        return null;
    }



}
