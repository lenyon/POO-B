package br.fatec.HelpDesk.dtos;

import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.entities.Perfil;

import java.io.Serial;
import java.io.Serializable;

public record CategoriaDTO(

        Long id,
        String servico

) implements Serializable {

    @Serial
    public static final long serialVersionUID = -123234235235L;

    public static CategoriaDTO valueof(Categoria categoria) {
        if (categoria != null) {
            return new CategoriaDTO(
                    categoria.getId(),
                    categoria.getServico()
            );
        }
        return null;
    }

    public static Categoria toCategoria(CategoriaDTO dto) {
        if (dto != null){
            Categoria categoria = new Categoria();
            categoria.setId(dto.id);
            categoria.setServico(dto.servico);
            return categoria;
        }
        return  null;
    }

}
