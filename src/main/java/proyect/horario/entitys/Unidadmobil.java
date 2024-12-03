package proyect.horario.entitys;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Unidadmobil{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idunidadmobil;

    @ManyToOne
    @JoinColumn(name = "categoriamobil")
    private Categoria categoriamobil;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "estadomobil")
    private Estado estadomobil;

}
