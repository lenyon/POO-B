package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.repositories.EquipeRepository;
import br.fatec.HelpDesk.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    EquipeRepository equipeRepository;

    public Equipe cadastrar(String nomeEquipe){
        Equipe equipe = new Equipe();
        equipe.setEquipe(nomeEquipe);
        return equipeRepository.save(equipe);
    }

    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    public Equipe findById (Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    public List<Equipe> findAllById (List<Long> ids) {
        return equipeRepository.findAllById(ids);
    }
}
