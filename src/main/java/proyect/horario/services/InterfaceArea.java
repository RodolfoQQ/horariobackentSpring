package proyect.horario.services;
import proyect.horario.entitys.Areatrabajo;
import java.util.List;

public interface InterfaceArea {
    List<Areatrabajo> listAreas();
    Areatrabajo findbyAreades(Integer descripcion);
}
