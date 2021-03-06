package adzarei.loe.server.api.domain;

import adzarei.loe.server.security.model.LoginUser;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numlibro;
    private LocalDateTime fAutorizacion;
    private LocalDateTime fInicioObra;
    private LocalDateTime fFinObra;
    private String numExpColegio;
    private String obra;
    private String situacion;
    private String numLicencia;
    private String ayto;
    private LocalDateTime fLicencia;

    private String CAE;
    private LocalDateTime fCAE;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "login_user_id")
    private LoginUser propietario;

    @OneToMany(orphanRemoval = true,mappedBy = "libro")
    private List<Agente> agentes = new ArrayList<>();

    @OneToMany(orphanRemoval = true,mappedBy = "libro")
    private List<Acta> actas = new ArrayList<>();

    @OneToMany(orphanRemoval = true) //TODO: decide on relation
    private List<Firma> firmas = new ArrayList<>();
    
    public Firma addFirma(Firma firma){
      firmas.add(firma);
      return firma;
    }

    public Agente addAgente (Agente agente){
      agente.setLibro(this);
      this.agentes.add(agente);
      return agente;
    }

    public Acta addActa(Acta acta){
      acta.setLibro(this);
      return acta;
    }


}
