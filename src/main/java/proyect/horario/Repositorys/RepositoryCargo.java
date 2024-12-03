package proyect.horario.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyect.horario.entitys.Cargo;

@Repository
public interface RepositoryCargo extends JpaRepository<Cargo, Integer> {

   //Cargo findByIdcargo(Integer nombrecargo);

}
