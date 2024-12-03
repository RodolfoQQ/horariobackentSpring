package proyect.horario.services;

import proyect.horario.entitys.Cargo;

import java.util.List;

public interface InterfaceCArgo {
    List<Cargo> listacargos();

    Cargo findbyname(Integer cargo);
}
