package proyect.horario.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.horario.Repositorys.RepositoryPuesto;
import proyect.horario.entitys.Puesto;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicePuesto implements  InterfacePuesto{

    private RepositoryPuesto repositoryPuesto;

    @Override
    public List<Puesto> listapuestos() {
        return repositoryPuesto.findAll();
    }

}
