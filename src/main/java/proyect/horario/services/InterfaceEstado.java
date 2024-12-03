package proyect.horario.services;

import proyect.horario.entitys.Estado;

import java.util.List;

public interface InterfaceEstado {

    List<Estado> listaestado();

    List<Object[]>estadospersonas();

    Estado findbyestado(Integer estado);

}
