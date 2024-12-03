package proyect.horario.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proyect.horario.Dtos.Dtomobil;
import proyect.horario.entitys.Puesto;
import proyect.horario.entitys.Unidadmobil;

import java.util.List;
import java.util.Objects;

public interface Interfaceunidadmobil {

    List<Dtomobil> unidadesmobilesdisponibles();

    void updatemobilOcupada(String mobil);

    void updatemobilDisponible(String mobil);

   public Unidadmobil findUnidadmobilbyid(Integer idunidadmobil);

   public  Unidadmobil findunidadmobilbyDesc (String mobil);

    void  updatepuestoencabe (Integer idnuevopuesto, Integer idcabe);


    //    Dtomobil findbyunidadmobil(String descripcion);
}
