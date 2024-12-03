package proyect.horario.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.horario.Repositorys.RepositoryCargo;
import proyect.horario.entitys.Cargo;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceCargo implements InterfaceCArgo {

    private RepositoryCargo repository;

    @Override
    public List<Cargo> listacargos() {
        return repository.findAll();

    }

    @Override
    public Cargo findbyname(Integer cargo) {
        return repository.findById(cargo).orElse(null);
    }
}
