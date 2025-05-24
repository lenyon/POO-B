package br.fatec.HelpDesk.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "Usuario", schema = "public")
public class Usuario implements Serializable {

    @Serial
    public static final long serialVersionUID = 5345345421431312L;

    @Id
    @SequenceGenerator(
            name = "SEQ-USUARIO",
            sequenceName = "public.seq-usuario",
            allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQ-USUARIO")
    private Long id;

    @Column (name = "nome", nullable = false, length = 255)
    private String nome;

    @Column (name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column (name = "senha", nullable = false, length = 255)
    private String senha;

    @Column (name = "cargo", length = 80)
    private String cargo;

    @Column (name = "telefone", length = 30)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_perfil", referencedColumnName = "id",
            insertable = true, updatable = true)
    private Perfil perfil;


    //Possibilidade de alteracao para UsuarioEquipe em vez de Equipe para manter persistencia de dados
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UsuarioEquipe> usuarioEquipes = new ArrayList<>();

    public List<Equipe> getEquipes () {
        return usuarioEquipes.stream().
                map(UsuarioEquipe::getEquipe)
                .collect(Collectors.toList());
    }


}
