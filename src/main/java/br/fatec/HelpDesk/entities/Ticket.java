package br.fatec.HelpDesk.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table (name = "Ticket", schema = "public")
public class Ticket implements Serializable {

    @Serial
    public static final long serialVersionUID = 452564367567L;

    @Id
    @SequenceGenerator(
            name = "SEQ-TICKET",
            sequenceName = "public.seq_ticket",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ-TICKET")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario solicitante;

    @Column(name = "data_abertura", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataAbertura;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 1000, columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ultimo_status", referencedColumnName = "status",nullable = false)
    private Status ultimoStatus;

    @Column(name = "relatorio_interno", length = 1000, columnDefinition = "TEXT")
    private String relatorioInterno;

    @Column(name = "data_conclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataConclusao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ticket")
    private List<Atendimento> atendimentos;

    @ManyToOne
    @JoinColumn(name = "id_equipe", referencedColumnName = "id")
    private Equipe equipe;


}
