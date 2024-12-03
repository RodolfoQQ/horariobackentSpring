package proyect.horario.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyect.horario.entitys.Cabecerapuesto;

@Repository
public interface RepositoryDetallePuestoPat extends JpaRepository<Cabecerapuesto,Integer> {

}
