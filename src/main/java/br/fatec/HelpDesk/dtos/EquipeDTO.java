package br.fatec.HelpDesk.dtos;

import br.fatec.HelpDesk.entities.Equipe;
import br.fatec.HelpDesk.entities.Perfil;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public record EquipeDTO(

        Long id,
        String equipe

) implements Serializable {

    @Serial
    public static final long serialVersionUID = -123234235235L;

    public static EquipeDTO valueof(Equipe equipe) {
        if (equipe != null) {
            return new EquipeDTO(
                    equipe.getId(),
                    equipe.getEquipe()
            );
        }
        return null;
    }

    public static Equipe toEquipe(EquipeDTO equipeDTO) {
        if (equipeDTO != null){
            Equipe equipe = new Equipe();
            equipe.setId(equipeDTO.id);
            equipe.setEquipe(equipeDTO.equipe);
            return equipe;
        }
        return  null;
    }

    public static List<EquipeDTO> valueAll(List<Equipe> equipes) {
        if (equipes != null && !equipes.isEmpty()) {
            List<EquipeDTO> dtos = new ArrayList<>();
            equipes.forEach(equipe ->
                    dtos.add(valueof(equipe))
            );
            return dtos;
        }
        return null;
    }

}
