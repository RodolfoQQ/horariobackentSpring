package proyect.horario.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyect.horario.Dtos.Dtopnp;
import proyect.horario.Dtos.Dtosavepnp;
import proyect.horario.entitys.*;
import proyect.horario.services.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/pnp")
//@CrossOrigin(origins={"https://localhost:4300"},originPatterns = {"*"})
public class ControllerPNP {

    private InterfaceCArgo icargo;
    private InterfaceGrado igrado;
    private InterfaceArea iareatrabajo;
    private InterfaceEstado iestado;
    private InterfacePNP ipnp;

    @GetMapping("/cargolista")
    public ResponseEntity<?> listaCargos() {
        List<Cargo> listacargos = icargo.listacargos();
        return ResponseEntity.status(HttpStatus.OK).body(listacargos);
    }

    @GetMapping("/grados")
    public ResponseEntity<?> listaGrados() {
        List<Grado> listagrados = igrado.listagrados();
        return ResponseEntity.status(HttpStatus.OK).body(listagrados);
    }

    @GetMapping("/areatrabajo")
    public ResponseEntity<List<Areatrabajo>> listaareatrabajo() {
        List<Areatrabajo> listyabajo = iareatrabajo.listAreas();
        return ResponseEntity.status(HttpStatus.OK).body(listyabajo);
    }

    @GetMapping("/estadospersona")
    public ResponseEntity<?> listaestados() {
        List<Object[]> listaestados = iestado.estadospersonas();

        List<Map<String, Object>> estado = listaestados.stream().map(est -> {
            Map<String, Object> map = new HashMap<>();
            map.put("idestado", est[0]);
            map.put("nombreestado", est[1]);
            return map;
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(estado);
    }

    @PostMapping("/savepnp")
    public ResponseEntity<?>savePNP (@RequestBody Dtosavepnp dpnp){
            Pnp pnp=new Pnp();
                pnp.setCip(dpnp.getCip());
                pnp.setGrado(igrado.findbyGrado(dpnp.getIdgrado()));
                pnp.setNombre(dpnp.getNombre());
                pnp.setApellido(dpnp.getApellido());
                pnp.setEstadopnp(iestado.findbyestado(dpnp.getIdestado()));
                pnp.setCargo(icargo.findbyname(dpnp.getIdcargo()));
                pnp.setAreatrabajo(iareatrabajo.findbyAreades(dpnp.getIdareatrabajo()));
                ipnp.savepnp(pnp);

     return  ResponseEntity.status(HttpStatus.CREATED).body(pnp);
}

    @PutMapping("/actualizarpnp/{cip}")
    public ResponseEntity<?> actualizarpnp(@PathVariable String cip, @RequestBody Dtosavepnp dpnp) {
        HashMap<String, Object> response = new HashMap<>();

        // Buscar PNP por CIP
        Pnp efectivo = ipnp.findByCip(cip);
        if (efectivo == null) {
            response.put("mensaje", "El usuario no existe en la base de datos");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Validar si el ID del área en el DTO es distinto del área actual del efectivo
        Integer idAreaActual = efectivo.getAreatrabajo() != null ? efectivo.getAreatrabajo().getIdareatrabajo() : null;
        System.out.println("ID de área en DTO: " + dpnp.getIdareatrabajo());
        System.out.println("ID de área en entidad: " + idAreaActual);

        // Crear el objeto actualizado a partir del DTO
        efectivo.setCip(dpnp.getCip());
        efectivo.setNombre(dpnp.getNombre());
        efectivo.setApellido(dpnp.getApellido());
        efectivo.setGrado(igrado.findbyGrado(dpnp.getIdgrado()));
        efectivo.setCargo(icargo.findbyname(dpnp.getIdcargo()));
        efectivo.setAreatrabajo(iareatrabajo.findbyAreades(dpnp.getIdareatrabajo()));
        // Actualizar cabecerapuesto y estado si las áreas son diferentes
        if (!dpnp.getIdareatrabajo().equals(idAreaActual)) {
            System.out.println("Las áreas son diferentes. Se establecerá cabecerapuesto en null y estado en 'disponible'.");

            // Cambiar cabecerapuesto a null
            efectivo.setCabecerapuesto(null);

            // Cambiar el estado a "disponible" (ID 1)
            Estado estadoDisponible = iestado.findbyestado(1);
            efectivo.setEstadopnp(estadoDisponible);
        } else {
            System.out.println("Las áreas son iguales. No se cambia la cabecera ni el estado.");
        }

        // Guardar los cambios en la base de datos
        Pnp pnpGuardado = ipnp.savepnp(efectivo); // guardamos y retornamos el objeto actualizado
        if (pnpGuardado != null) {
            System.out.println("PNP guardado correctamente: " + pnpGuardado);
            response.put("mensaje", "Se actualizó correctamente el PNP");
            return ResponseEntity.status(HttpStatus.OK).body(pnpGuardado);
        } else {
            response.put("mensaje", "Error al guardar el PNP actualizado.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/findbycip/{cip}")
    public ResponseEntity<?> findbycip(@PathVariable String cip) {
        Object pnp = ipnp.encontroarporcipdto(cip);
        if (pnp!=null) {
            Dtopnp dtopnp = ipnp.findpnpbycip(cip);
            return ResponseEntity.ok(dtopnp);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no existe en la base de datos");
    }

    @GetMapping("/listaporpeloton/{peloton}") // Asegúrate de que este mapeo esté correcto
    public ResponseEntity<List<Dtopnp>>listapnpporpeloton(@PathVariable String peloton) {
        // Lógica para obtener la lista de Dtopnp
        return ResponseEntity.ok(ipnp.dtopnptodoslosestados(peloton));
    }

    @GetMapping("/pnpporpelotonyarea/{idcabe}/{area}")
    public ResponseEntity<?> pnpporpelotonyarea(@PathVariable Integer idcabe, @PathVariable Integer area) {
       List<Pnp> pnps=ipnp.pnpporpelotonyarea(idcabe, area);
       if(pnps==null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro");
       }
       return  ResponseEntity.status(HttpStatus.OK).body(pnps);
    }

    @GetMapping("/dtopnpsinparametros")
    public ResponseEntity<List<Dtopnp>> dtosinparametros(){
        List<Dtopnp> listapnp=ipnp.dtopnpsinparametros();
        return ResponseEntity.status(HttpStatus.OK).body(listapnp);
    }



}
