package proyect.horario.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyect.horario.entitys.Puesto;

@Repository
public interface RepositoryPuesto extends JpaRepository<Puesto,Integer> {

}
