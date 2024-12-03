package proyect.horario.services;

import org.springframework.data.repository.query.Param;
import proyect.horario.entitys.Cabecerapuesto;

import java.util.List;

public interface InterfaceCabecera {

    List<Cabecerapuesto> listacabeceradeserviciospatrulleros (String peloton);

   List<Cabecerapuesto> listasolocabecera ();

   void editarpatrulleroencabecera(String mobile, String cabeceraid);

   Cabecerapuesto anadircabecera( Cabecerapuesto cabecerapuesto);

    void updatemobilencabecera(Integer idunidadmobil, Integer idcabecerapuesto);

    public Cabecerapuesto findbyidcabecerapuesto(Integer idcabecerapuesto);

    void eliminarcabecera(Integer id);
}
