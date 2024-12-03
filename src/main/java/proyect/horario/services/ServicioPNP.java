package proyect.horario.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import proyect.horario.Dtos.Dtopnp;
import proyect.horario.Repositorys.RepositoryPNP;
import proyect.horario.entitys.Pnp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ServicioPNP implements  InterfacePNP {

    private RepositoryPNP repositoryPNP;

    @Override
    public List<Pnp> listapnp() {

        return repositoryPNP.findAll();
    }

    @Override
    public void actualizarCabeceraenpnpennull(String cip) {
        repositoryPNP.actualizarestadoendisponible(cip);
        repositoryPNP.quitarefectivodecabecera(cip);
    }

    @Override
    public Pnp findByCip(String idpnp) {
        return repositoryPNP.findByCip(idpnp);
    }

    @Override
    public Object encontroarporcipdto(String cip) {
        return repositoryPNP.cippnp(cip);
    }



    @Transactional
    @Override
    public void agregarpnpacabecera(Integer idcabe, String cip) {
        Pnp efectivo = repositoryPNP.findByCip(cip);
        if (efectivo != null) {
            repositoryPNP.actualizarestadoaocupado(cip);
            repositoryPNP.agrregarpnp(idcabe, cip);
        }
    }

    @Override
    public Dtopnp findpnpbycip(String cip) {
        Object[] result = (Object[]) repositoryPNP.pnpdtofidncip(cip);
        if (result != null) {
            return new Dtopnp(
                    (String) result[0], // nombregrado
                    (String) result[1], // apellido
                    (String) result[2], // nombre
                    (String) result[3], // nombrecargo
                    (String) result[4], // peloton
                    (String) result[5], // cip
                    (String) result[6]  // estado
            );
        }
        return null; // Retorna null o lanza una excepción si no hay resultados
    }

    @Override
    public List<Dtopnp> listadtopnp(String peloton) {
        List<Object[]> dtopnplista = repositoryPNP.dtopnp(peloton);
        return dtopnplista.stream().map(data -> new Dtopnp(
                (String) data[0], // nombregrado
                (String) data[1], // apellido
                (String) data[2], // nombre
                (String) data[3], // nombrecargo
                (String) data[4],  // descripcion
                (String) data[5],
                (String) data[6]
        )).collect(Collectors.toList());
    }

    @Override
    public List<Dtopnp> dtopnptodoslosestados(String peloton) {
        List<Object[]> dtopnplista = repositoryPNP.dtopnptodoslosestados(peloton);
        return dtopnplista.stream().map(data -> new Dtopnp(
                (String) data[0], // nombregrado
                (String) data[1], // apellido
                (String) data[2], // nombre
                (String) data[3], // nombrecargo
                (String) data[4],  // descripcion
                (String) data[5],
                (String) data[6]
        )).collect(Collectors.toList());
    }




    @Transactional
    @Override
    public void actualizarestadoaocupado(String cip) {
        repositoryPNP.actualizarestadoaocupado(cip);

    }

    @Override
    public void actualizarestadoendisponible(String cip) {
        repositoryPNP.actualizarestadoendisponible(cip);
    }

    @Override
    public List<Pnp> listapnpporidcabypeloton(String peloton, Integer cabe) {
        return repositoryPNP.listapnpporidcabypeloton(peloton, cabe);
    }

    @Transactional
    @Override
    public Pnp savepnp(Pnp pnp) {
        return repositoryPNP.save(pnp);
    }

    @Override
    public Pnp findbyidpnp(Integer idpnp) {
        return repositoryPNP.findById(idpnp)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la entidad con id: " + idpnp));
    }

    @Override
    public List<Pnp> findbycabecerayarea(Integer idcabe, Integer idarea) {
        return repositoryPNP.findbycabecerayarea(idcabe, idarea);
    }

    @Override
    public List<Pnp> findbycabeceras(Integer idcabe) {
        return repositoryPNP.findbycabeceras(idcabe);
    }

    @Override
    public List<Pnp> pnpporpelotonyarea(Integer idcabe, Integer area) {
        return repositoryPNP.pnpporpelotonyarea(idcabe, area);
    }
}








