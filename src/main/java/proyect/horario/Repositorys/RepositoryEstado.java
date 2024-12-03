package proyect.horario.Repositorys;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proyect.horario.entitys.Estado;

import java.util.List;

@Repository
public interface RepositoryEstado extends JpaRepository<Estado,Integer> {

    @Query(value = "select e.idestado ,  e.nombreestado  from estado e inner join categoria c on c.idcategoria =e.categoria where c.descripcioncategoria  ='persona' \n", nativeQuery = true)
    List<Object[]> listaestadospersona();

    //Estado findByNombreestado(Integer nombreestado);

}
