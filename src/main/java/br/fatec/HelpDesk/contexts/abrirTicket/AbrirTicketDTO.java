package br.fatec.HelpDesk.contexts.abrirTicket;

import br.fatec.HelpDesk.contexts.usuarioEquipe.UsuarioEquipeDTO;
import br.fatec.HelpDesk.entities.Ticket;
import br.fatec.HelpDesk.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public record AbrirTicketDTO(

        @NotNull (message = "Usuario nao pode ser nulo.")
        Long id_usuario,

        @NotBlank(message = "Titulo e um campo obrigatorio.")
        String titulo,

        @NotBlank(message = "Descricao e um campo obrigatorio.")
        String descricao,

         @NotNull(message = "Equipe e obrigatoria ser informada.")
        Long id_equipe

) implements Serializable {

    @Serial
    public static final long serialVersionUID =634375436456L;

}
