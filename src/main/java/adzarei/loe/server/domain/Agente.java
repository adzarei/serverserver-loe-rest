package adzarei.loe.server.domain;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoAgente tipoAgente;

    private String nombre;
    private String idFiscal;
    private String titulo;
    private LocalDateTime fInicio;
    private LocalDateTime fFin;
}
