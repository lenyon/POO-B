package br.fatec.HelpDesk.contexts.autenticacao;

import br.fatec.HelpDesk.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    AutenticacaoRepository autenticacaoRepository;

    public Usuario autenticar(String email, String senha) {
        return autenticacaoRepository.findByEmailSenha(email, senha).orElse(null);
    }
}
