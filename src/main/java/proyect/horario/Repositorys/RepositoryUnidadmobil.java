package proyect.horario.Repositorys;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyect.horario.Dtos.Dtomobil;
import proyect.horario.entitys.Unidadmobil;

import java.util.List;

@Repository
public interface RepositoryUnidadmobil extends JpaRepository<Unidadmobil, Integer> {

    @Query("select new proyect.horario.Dtos.Dtomobil(u.idunidadmobil, u.descripcion, e.nombreestado) " +
            "from Unidadmobil u inner join u.estadomobil e where e.nombreestado='uumm disponible'")
    List<Dtomobil> unidadesmobilesdisponibles();

    @Modifying
    @Transactional
    @Query(value = "update unidadmobil  set estadomobil =4 where descripcion  = :mobil",nativeQuery = true)
    void updatemobilOcupada(@Param("mobil")String mobil);

    @Transactional
    @Modifying
    @Query(value = "update unidadmobil  set estadomobil =5 where descripcion  = :mobil",nativeQuery = true)
    void updatemobilDisponible(@Param("mobil")String mobil);

    Unidadmobil findByDescripcion (@Param("descripcion")String descripcion);

    @Transactional
    @Modifying
    @Query(value = "update cabecerapuesto set puesto= :idnuevopuesto where idcabecerapuesto= :idcabe",nativeQuery = true)
    void  updatepuestoencabe (@Param("idnuevopuesto") Integer idnuevopuesto, @Param("idcabe") Integer idcabe);
}
