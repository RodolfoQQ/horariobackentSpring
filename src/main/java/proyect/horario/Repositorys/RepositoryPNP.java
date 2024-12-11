package proyect.horario.Repositorys;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import proyect.horario.Dtos.Dtopnp;
import proyect.horario.entitys.Pnp;

import java.util.List;

@Repository
public interface RepositoryPNP extends JpaRepository<Pnp,Integer>{

    @Modifying
    @Transactional
    @Query(value = "UPDATE pnp SET idcabecerapuesto = NULL WHERE cip = :cip", nativeQuery = true)
    void quitarefectivodecabecera(@Param("cip") String cip);

    @Modifying
    @Transactional
    @Query(value = "update pnp set idcabecerapuesto = :idcabe where cip =:cip", nativeQuery = true)
    void agrregarpnp(@Param("idcabe") Integer idcabe, @Param("cip") String cip);

    Pnp findByCip(String idpnp);

    @Query(value ="\n" +
            "select g.nombregrado , p.apellido ,p.nombre, c.nombrecargo, a.descripcion, p.cip, e.nombreestado  from pnp p inner join areatrabajo a \n" +
            "on  p.idareatrabajo =a.idareatrabajo\n" +
            "inner join cargo c \n" +
            "on p.cargo  =c.idcargo  \n" +
            "inner join grado g on p.grado =g.idgrado inner join estado e on p.idestado =e.idestado \n" +
            "where a.descripcion = :peloton and  p.idestado =1", nativeQuery = true)
    List<Object[]> dtopnp(@Param("peloton") String peloton);

    @Query(value ="select g.nombregrado , p.apellido ,p.nombre, c.nombrecargo, a.descripcion, p.cip, e.nombreestado  from pnp p inner join areatrabajo a\n" +
            "          on  p.idareatrabajo =a.idareatrabajo\n" +
            "            inner join cargo c \n" +
            "            on p.cargo  =c.idcargo\n" +
            "            inner join grado g on p.grado =g.idgrado inner join estado e on p.idestado =e.idestado", nativeQuery = true)
    List<Object[]> dtopnpsinparametros();





    @Query(value ="\n" +
            "select g.nombregrado , p.apellido ,p.nombre, c.nombrecargo, a.descripcion, p.cip, e.nombreestado  from pnp p inner join areatrabajo a \n" +
            "on  p.idareatrabajo =a.idareatrabajo\n" +
            "inner join cargo c \n" +
            "on p.cargo  =c.idcargo  \n" +
            "inner join grado g on p.grado =g.idgrado inner join estado e on p.idestado =e.idestado  \n" +
            "where a.descripcion = :peloton", nativeQuery = true)
    List<Object[]> dtopnptodoslosestados(@Param("peloton") String peloton);


    @Query(value = "select p.cip  from pnp p where p.cip = :cip", nativeQuery = true)
    Object cippnp (@Param("cip") String cip);

    @Query(value ="\n" +
            "select g.nombregrado , p.apellido ,p.nombre, c.nombrecargo, a.descripcion, p.cip, e.nombreestado  from pnp p inner join areatrabajo a \n" +
            "on  p.idareatrabajo =a.idareatrabajo\n" +
            "inner join cargo c \n" +
            "on p.cargo  =c.idcargo  \n" +
            "inner join grado g on p.grado =g.idgrado inner join estado e on p.idestado =e.idestado  \n" +
            "where p.cip = :cip", nativeQuery = true)
    Object pnpdtofidncip (@Param("cip") String cip);


    @Modifying
    @Query(value ="\n" +
            "update pnp set idestado = 3 where  cip =:cip", nativeQuery = true)
    void actualizarestadoaocupado(@Param("cip") String cip);

    @Transactional
    @Modifying
    @Query(value ="update pnp set idestado =1 where cip =:cip", nativeQuery = true)
    void  actualizarestadoendisponible(@Param("cip") String cip);

    @Transactional
    @Query(value ="select p.* from pnp p  left join areatrabajo a on p.idareatrabajo =a.idareatrabajo where a.descripcion = :peloton and p.idcabecerapuesto  =:cabe\n", nativeQuery = true)
    List<Pnp> listapnpporidcabypeloton(@Param("peloton") String peloton, @Param("cabe") Integer cabe);


    @Query(value = "select * from pnp where idcabecerapuesto  = :cabe and idareatrabajo =:idarea",nativeQuery = true)
    List<Pnp> findbycabecerayarea(@Param("cabe") Integer cabe, @Param("idarea") Integer idarea);

    @Query(value = "select * from pnp where idcabecerapuesto = :cabe",nativeQuery = true)
    List<Pnp> findbycabeceras(@Param("cabe") Integer idcabe);

    @Query(value = "select * from pnp  where   idcabecerapuesto = :idcabe and idareatrabajo = :area",nativeQuery = true)
    List<Pnp> pnpporpelotonyarea (@Param("idcabe") Integer idcabe, @Param("area") Integer area);

}


