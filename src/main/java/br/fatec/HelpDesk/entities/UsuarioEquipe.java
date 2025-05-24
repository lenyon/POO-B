package br.fatec.HelpDesk.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
            name = "SEQ_USUARIO_EQUIPE",
            sequenceName = "public.seq_usuario_equipe",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_EQUIPE")
    private Long id;

    @Column (name = "ativo", length = 350)
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_equipe", referencedColumnName = "id")
    private Equipe equipe;



}