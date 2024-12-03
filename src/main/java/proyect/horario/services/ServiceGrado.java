package proyect.horario.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.horario.Repositorys.RepositoryGrado;
import proyect.horario.entitys.Grado;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceGrado implements  InterfaceGrado{

    private RepositoryGrado repostory;

    @Override
    public List<Grado> listagrados() {
        return repostory.findAll();
    }

    @Override
    public Grado findbyGrado(Integer grado) {
        return repostory.findById(grado).orElse(null);
    }
}
