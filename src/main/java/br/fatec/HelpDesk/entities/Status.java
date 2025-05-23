package br.fatec.HelpDesk.entities;

import br.fatec.HelpDesk.enums.TipoStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.security.SecureRandomParameters;

@Entity
@Data
@Table(name = "status", schema = "public")
public class Status implements Serializable {

    @Serial
    private static final long serialVersionUID = 64564452432L;

    @Id
    @Column(name = "status", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private TipoStatus status;


}
