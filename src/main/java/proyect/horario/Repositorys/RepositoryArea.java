package proyect.horario.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyect.horario.entitys.Areatrabajo;


@Repository
public interface RepositoryArea extends JpaRepository<Areatrabajo,Integer> {

  // public Areatrabajo findByDescripcion(Integer descripcion);
}
