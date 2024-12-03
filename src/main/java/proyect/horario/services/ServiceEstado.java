package proyect.horario.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.horario.Repositorys.RepositoryEstado;
import proyect.horario.entitys.Estado;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceEstado implements  InterfaceEstado{
    private RepositoryEstado repository;

    @Override
    public List<Estado> listaestado() {

        return repository.findAll();
    }

    @Override
    public List<Object[]> estadospersonas() {
        List<Object[]> lista =repository.listaestadospersona();

        return lista;
    }

    @Override
    public Estado findbyestado(Integer estado) {
        return repository.findById(estado).orElse(null
        );
    }
}
