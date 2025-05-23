package br.fatec.HelpDesk.contexts.abrirTicket;

import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;

public record AbrirTicketDTO(
        @NotEmpty (message = "Usuario nao pode ser nulo.")
        Long id_usuario,
        @NotEmpty(message = "Titulo e um campo obrigatorio.")
        String titulo,
        @NotEmpty(message = "Descricao e um campo obrigatorio.")
        String descricao,
        @NotEmpty(message = "Equipe e obrigatoria ser informada.")
        Long id_equipe
) implements Serializable {

    @Serial
    public static final long serialVersionUID =634375436456L;




}
