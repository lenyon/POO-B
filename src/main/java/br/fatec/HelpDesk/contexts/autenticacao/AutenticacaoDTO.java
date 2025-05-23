package br.fatec.HelpDesk.contexts.autenticacao;

import br.fatec.HelpDesk.entities.Usuario;

import java.io.Serializable;

public record AutenticacaoDTO(
        String nome,
        String cargo,
        String email,
        String perfil
) implements Serializable {

    public static final long serilVersionUID = -13413113513513L;

    public static AutenticacaoDTO valueof(Usuario usuario) {
        if(usuario != null) {
            return new AutenticacaoDTO(
                    usuario.getNome(),
                    usuario.getCargo(),
                    usuario.getEmail(),
                    usuario.getPerfil().getPerfil()
            );
        }
        return  null;
    }

}
