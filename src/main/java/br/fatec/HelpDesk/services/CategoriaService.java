package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.repositories.CategoriaRepository;
import br.fatec.HelpDesk.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria cadastrar(String servico){
        Categoria categoria = new Categoria();
        categoria.setServico(servico);
        return categoriaRepository.save(categoria);
    }
}
