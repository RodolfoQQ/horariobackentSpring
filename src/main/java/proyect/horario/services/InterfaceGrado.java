package proyect.horario.services;

import proyect.horario.entitys.Grado;

import java.util.List;

public interface InterfaceGrado {

    public List<Grado> listagrados();
     Grado findbyGrado(Integer grado);
}
