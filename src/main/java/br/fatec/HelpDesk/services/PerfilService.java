package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Perfil;
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

    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

}
