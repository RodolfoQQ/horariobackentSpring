package proyect.horario.Repositorys;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyect.horario.entitys.Cabecerapuesto;

import java.util.List;

@Repository
public interface RepositoryCabecera extends JpaRepository<Cabecerapuesto,Integer> {

    @Query(value = "SELECT DISTINCT c.* FROM cabecerapuesto c "
            + "LEFT JOIN pnp p ON p.idcabecerapuesto = c.idcabecerapuesto "
            + "LEFT JOIN areatrabajo a ON a.idareatrabajo = p.idareatrabajo "
            + "AND a.descripcion = :descripcion", nativeQuery = true)
    List<Cabecerapuesto> listaservicioporpeloton(@Param("descripcion") String descripcion);

    @Query(value = "update cabecerapuesto set idunidadmobil = :mobil where  idcabecerapuesto = :cabeceraid",nativeQuery = true)
    void editarpatrulleroencabecera(@Param("mobil") String mobil, @Param("cabeceraid") String cabeceraid);

    @Modifying
    @Query(value = "update cabecerapuesto set idunidadmobil = :idunidadmobil where idcabecerapuesto = :idcabecerapuesto", nativeQuery = true)
    void updatemobilencabecera(@Param("idunidadmobil") Integer idunidadmobil, @Param("idcabecerapuesto") Integer idcabecerapuesto);

}
