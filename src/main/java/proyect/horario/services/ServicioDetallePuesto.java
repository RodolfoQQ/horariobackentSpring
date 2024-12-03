package proyect.horario.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.horario.Repositorys.RepositoryDetallePuestoPat;
import proyect.horario.entitys.Cabecerapuesto;

import java.util.List;

@AllArgsConstructor
@Service
public class ServicioDetallePuesto implements InterfaceDetallePat{

private RepositoryDetallePuestoPat repository;

    @Override
    public List<Cabecerapuesto> listadetallepatrullaje() {

        return repository.findAll();
    }
}
