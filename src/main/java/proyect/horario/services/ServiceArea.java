package proyect.horario.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.horario.Repositorys.RepositoryArea;
import proyect.horario.entitys.Areatrabajo;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceArea implements  InterfaceArea {

    private RepositoryArea repositoryArea;


    @Override
    public List<Areatrabajo> listAreas() {
        return repositoryArea.findAll();
    }

    @Override
    public Areatrabajo findbyAreades(Integer descripcion) {
        return repositoryArea.findById(descripcion).orElse(null);
    }


}
