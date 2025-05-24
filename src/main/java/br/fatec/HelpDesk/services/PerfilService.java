package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    public Perfil cadastrar(String nomePerfil){
        return perfilRepository.save(new Perfil(nomePerfil));
    }

    public Perfil findById (Long id) {
        if(id != null) {
            return perfilRepository.findById(id).orElse(null);
        }
        return null;
    }

    public List<Perfil> findAllById (List<Long> ids) {
        return perfilRepository.findAllById(ids);
    }

    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

}
