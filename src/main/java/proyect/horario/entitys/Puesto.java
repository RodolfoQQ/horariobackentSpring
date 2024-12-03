package proyect.horario.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idpuesto;

    private String descripcionpuesto;



}
