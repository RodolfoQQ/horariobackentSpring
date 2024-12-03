package proyect.horario.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Integer idcategoria;

    private   String nombrecategoria;

    private   String descripcioncategoria;


}

