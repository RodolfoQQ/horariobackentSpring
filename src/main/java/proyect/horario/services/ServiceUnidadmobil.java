package proyect.horario.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.horario.Dtos.Dtomobil;
import proyect.horario.Repositorys.RepositoryUnidadmobil;
import proyect.horario.entitys.Unidadmobil;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ServiceUnidadmobil implements  Interfaceunidadmobil{

    private RepositoryUnidadmobil repository;

    @Override
    public List<Dtomobil> unidadesmobilesdisponibles() {
        return repository.unidadesmobilesdisponibles();
    }

    @Override
    public void updatemobilOcupada(String mobil) {
        repository.updatemobilOcupada(mobil);
    }

    @Override
    public void updatemobilDisponible(String mobil) {
        repository.updatemobilDisponible(mobil);
    }

    @Override
    public Unidadmobil findUnidadmobilbyid(Integer idunidadmobil) {
        return repository.findById(idunidadmobil).orElse(null);

    }

    @Override
    public Unidadmobil findunidadmobilbyDesc(String mobil) {
        return repository.findByDescripcion(mobil);
    }

    @Override
    public void updatepuestoencabe(Integer idnuevopuesto, Integer idcabe) {
    repository.updatepuestoencabe(idnuevopuesto, idcabe);
    }


}
