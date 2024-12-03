package proyect.horario.services;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.horario.Repositorys.RepositoryCabecera;
import proyect.horario.entitys.Cabecerapuesto;

import java.util.List;

@AllArgsConstructor
@Service
public class ServicioCabecera implements  InterfaceCabecera {

    private RepositoryCabecera reposcab;

  @Override
    public List<Cabecerapuesto> listacabeceradeserviciospatrulleros(String descripcion) {
        return reposcab.listaservicioporpeloton(descripcion);
    }

    @Override
    public List<Cabecerapuesto> listasolocabecera() {
        return reposcab.findAll();
    }

    @Override
    public void editarpatrulleroencabecera(String mobile, String cabeceraid) {
      reposcab.editarpatrulleroencabecera(mobile, cabeceraid);
    }

    @Override
    public Cabecerapuesto anadircabecera(Cabecerapuesto cabecerapuesto) {
        return reposcab.save(cabecerapuesto);
    }

    @Transactional
    @Override
    public void updatemobilencabecera(Integer idunidadmobil, Integer idcabecerapuesto) {
        reposcab.updatemobilencabecera(idunidadmobil, idcabecerapuesto);
    }

    public Cabecerapuesto findbyidcabecerapuesto(Integer idcabecerapuesto){
       return reposcab.findById(idcabecerapuesto).orElse(null);
    }

    @Transactional
    @Override
    public void eliminarcabecera(Integer id) {
      reposcab.deleteById(id);
    }

}
