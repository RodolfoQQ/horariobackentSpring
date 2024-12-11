package proyect.horario.services;
import org.springframework.data.repository.query.Param;
import proyect.horario.Dtos.Dtopnp;
import proyect.horario.entitys.Pnp;

import java.util.List;

public interface InterfacePNP {

    List<Pnp> listapnp();

    void actualizarCabeceraenpnpennull(String cip);

      Pnp findByCip(String idpnp);

      Object encontroarporcipdto(String cip);

      Dtopnp findpnpbycip(String cip);

      void agregarpnpacabecera(Integer idcabe, String cip);

       List<Dtopnp> listadtopnp(String peloton);

        List<Dtopnp> dtopnptodoslosestados(String peloton);

       void actualizarestadoaocupado(String cip);

       void  actualizarestadoendisponible(String cip);

       List<Pnp> listapnpporidcabypeloton(String peloton, Integer cabe);

       Pnp savepnp(Pnp pnp);

       Pnp findbyidpnp(Integer idpnp);

       List<Pnp>  findbycabecerayarea(Integer idcabe, Integer idarea);

       List<Pnp> findbycabeceras(Integer idcabe);

       List<Pnp> pnpporpelotonyarea (Integer idcabe, Integer area);

       List<Dtopnp> dtopnpsinparametros();
}
