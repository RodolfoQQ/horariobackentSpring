package proyect.horario.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table
public class Pnp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpnp;

    private  String cip;

    @ManyToOne
    @JoinColumn(name = "idcabecerapuesto", nullable = true)
    @JsonBackReference
    private  Cabecerapuesto cabecerapuesto;

    @ManyToOne
    @JoinColumn(name = "grado")
    private Grado grado;

    private  String nombre;

    private  String apellido;

    @ManyToOne
    @JoinColumn(name = "idestado")
    private Estado estadopnp;

    @ManyToOne
    @JoinColumn(name = "cargo")
    private Cargo cargo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idareatrabajo")
    private Areatrabajo areatrabajo;

}

