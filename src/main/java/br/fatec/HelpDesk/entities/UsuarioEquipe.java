package br.fatec.HelpDesk.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario_equipe", schema = "public")
public class UsuarioEquipe implements Serializable {

    @Serial
    public static final long serialVersionUID = 53453425421431312L;

    @Id
    @SequenceGenerator(
            name = "SEQ-USUARIO-EQUIPE",
            sequenceName = "public.seq_usuario_equipe",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ-USUARIO-EQUIPE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_equipe", referencedColumnName = "id")
    private Equipe equipe;

}