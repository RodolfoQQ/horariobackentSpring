package proyect.horario.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.horario.Repositorys.RepositoryDetallePuestoPat;
import proyect.horario.entitys.Cabecerapuesto;

import java.util.List;

@Service
@AllArgsConstructor
public class PuestoPatrullaje implements  InterfaceDetallePat {

    private RepositoryDetallePuestoPat repodetalle;

    @Override
    public List<Cabecerapuesto> listadetallepatrullaje() {
        return  repodetalle.findAll();
    }
}
