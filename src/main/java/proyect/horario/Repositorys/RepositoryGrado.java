package proyect.horario.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyect.horario.entitys.Grado;
@Repository
public interface RepositoryGrado extends JpaRepository<Grado,Integer> {

   // Grado findByNombregrado(Integer grado);
}
