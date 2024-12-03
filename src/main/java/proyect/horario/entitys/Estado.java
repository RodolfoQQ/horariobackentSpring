package proyect.horario.entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.results.graph.Fetch;

@Getter
@Setter
@Entity
@Table
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestado;

    private String nombreestado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria")
    private Categoria categoria;

}
