package br.fatec.HelpDesk.dtos;

import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.entities.Usuario;

import java.io.Serial;
import java.io.Serializable;

public record UsuarioDTO(

        Long id,
        String nome,
        String email,
        String cargo,
        String telefone,
        PerfilDTO perfil

) implements Serializable {

    @Serial
    public static final long serialVersionUID = -123234235235L;

    public static UsuarioDTO valueof(Usuario usuario) {
        if (usuario != null) {
            return new UsuarioDTO(
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getCargo(),
                    usuario.getTelefone(),
                    PerfilDTO.valueof(usuario.getPerfil())
            );
        }
        return null;
    }

    public static Usuario toUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO != null && usuarioDTO.perfil != null){
            Usuario usuario = new Usuario();
            usuario.setId(usuarioDTO.id);
            usuario.setNome(usuarioDTO.nome);
            usuario.setEmail(usuarioDTO.email);
            usuario.setCargo(usuarioDTO.cargo);
            usuario.setTelefone(usuarioDTO.telefone);
            usuario.setPerfil(PerfilDTO.toPerfil(usuarioDTO.perfil));
            return usuario;
        }
        return  null;
    }

}
