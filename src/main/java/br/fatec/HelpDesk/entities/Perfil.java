package br.fatec.HelpDesk.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Perfil", schema = "public")
public class Perfil implements Serializable {

    @Serial
    public static final long serialVersionUID = 5345345421431312L;

    @Id
    @SequenceGenerator(
            name = "SEQ-PERFIL",
            sequenceName = "public.seq-perfil",
            allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.IDENTITY, generator = "SEQ-PERFIL")
    private Long id;

    @Column (name = "Perfil", nullable = false, length = 50)
    private String perfil;

    public Perfil () {}

    public Perfil (Long id, String perfil) {
        setId(id);
        setPerfil(perfil);
    }

    public Perfil (String perfil) {
        setPerfil(perfil);
    }

    public void setPerfil (String nomePerfil) {
        this.perfil = nomePerfil.toUpperCase();
    }

}
