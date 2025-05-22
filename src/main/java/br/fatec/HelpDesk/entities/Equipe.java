package br.fatec.HelpDesk.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Equipe", schema = "public")
public class Equipe implements Serializable {

    @Serial
    public static final long serialVersionUID = 5345345421431312L;

    @Id
    @SequenceGenerator(
            name = "SEQ-EQUIPE",
            sequenceName = "public.seq-equipe",
            allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.IDENTITY, generator = "SEQ-EQUIPE")
    private Long id;

    @Column (name = "Equipe", nullable = false, length = 50)
    private String equipe;

    public void setEquipe (String nomeEquipe) {
        this.equipe = nomeEquipe.toUpperCase();
    }

}
