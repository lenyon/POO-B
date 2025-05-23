package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario findById (Long id) {
        if(id != null) {
            return  usuarioRepository.findById(id).orElse(null);
        }
        return null;
    }

    public Usuario cadastrar(Usuario usuario) {
        if (usuario != null) {
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario mudarSenha(String email, String senhaAtual, String novaSenha) {
        Usuario usuario = findByEmail(email);
        if (usuario != null) {
            if(usuario.getSenha().equals(senhaAtual)){
                usuario.setSenha(novaSenha);
                return usuarioRepository.save(usuario);
            }
        }
        return null;
    }

    public Usuario findByEmail(String email) {
        if (email != null && !email.isEmpty()) {
            return usuarioRepository.findByEmail(email).orElse(null);
        }
        return null;
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.findById(id).ifPresent(usuario -> usuarioRepository.delete(usuario));

    }
}
