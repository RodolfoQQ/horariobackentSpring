package proyect.horario.entitys;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Cabecerapuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcabecerapuesto;

    @OneToMany(mappedBy = "cabecerapuesto")
    @JsonManagedReference
    private List<Pnp> efectivos;

    @ManyToOne
    @JoinColumn(name = "idunidadmobil",unique = true)
    private Unidadmobil mobil;

    @ManyToOne
    @JoinColumn(name = "puesto")
    private Puesto puesto;
}
