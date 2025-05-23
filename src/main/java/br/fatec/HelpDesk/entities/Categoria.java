package br.fatec.HelpDesk.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Categoria", schema = "public")
public class Categoria implements Serializable {

    @Serial
    public static final long serialVersionUID = 53453454211431312L;

    @Id
    @SequenceGenerator(
            name = "SEQ-CATEGORIA",
            sequenceName = "public.seq-categoria",
            allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQ-CATEGORIA")
    private Long id;

    @Column (name = "servico", nullable = false, length = 50)
    private String servico;

    public void setServico (String servico) {
        this.servico = servico.toUpperCase();
    }

}
