package proyect.horario.controllers;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyect.horario.Dtos.DtoEntity;
import proyect.horario.Dtos.Dtomobil;
import proyect.horario.Dtos.Dtopnp;
import proyect.horario.entitys.*;
import proyect.horario.services.*;
import proyect.horario.util.DtoUtil;

import java.util.*;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
//@CrossOrigin(origins={"http://localhost:4300"},originPatterns = {"*"})
public class ControllerPuesto {

    private InterfaceCabecera serviciocabecera;

    private ServicioDetallePuesto sericiodetallePat;

    private Interfaceunidadmobil iServicemobil;

    private InterfacePNP servicepnp;

    private InterfacePuesto iServiciopuesto;

    @GetMapping("/cabecera/{descripcion}")
    public ResponseEntity<?> listaCaberapatrulleros(@PathVariable String descripcion) {
        HashMap<String, Object> response = new HashMap<>();
        List<Cabecerapuesto> listaCaberapatrulleros = serviciocabecera.listasolocabecera();
        if (listaCaberapatrulleros == null) {
            response.put("mensaje", "No hay datos en la base de datos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.put("mensaje", listaCaberapatrulleros);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @GetMapping("/pnppeltoncabe/{peloton}/{cabe}")
    public ResponseEntity<List<Pnp>> listapnpporidcabypeloton(@PathVariable String peloton, @PathVariable Integer cabe) {
        List<Pnp> listpnp = servicepnp.listapnpporidcabypeloton(peloton, cabe);
        return ResponseEntity.status(HttpStatus.OK).body(listpnp);
    }

    @PostMapping("/anadircabecera")
    public ResponseEntity<Cabecerapuesto> anadirecabercaera(Cabecerapuesto cabecerapuesto) {
        serviciocabecera.anadircabecera(cabecerapuesto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping("/quitarpnp/{cip}")
    public ResponseEntity<?> quiatarefectivo(@PathVariable("cip") String cip) {
        HashMap<String, Object> response = new HashMap<>();
        if (!cip.isEmpty()) {
            servicepnp.actualizarCabeceraenpnpennull(cip);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @GetMapping("/{cip}")
    public ResponseEntity<?> findbyCip(@PathVariable String cip) {
        Map<String, Object> response = new HashMap<>();
        Pnp efectivo = servicepnp.findByCip(cip);
        if (efectivo == null) {
            response.put("mensaje", "No hay datos en la base de dasssstos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response.put("mensaje", efectivo);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PutMapping("/adpnpacabezera/{idcab}/{cip}")
    public ResponseEntity anadirpnpacabezera(@PathVariable Integer idcab, @PathVariable String cip) {
        HashMap<String, Object> response = new HashMap<>();
        Pnp efectivo = servicepnp.findByCip(cip);
        if (efectivo == null) {
            response.put("mensaje", "no existe el pnp ingresado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        servicepnp.agregarpnpacabecera(idcab, cip);
        response.put("mensaje", "datos actualizados correctamente");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/dtopnp/{peloton}")
    public ResponseEntity<?> dtoPnp(@PathVariable String peloton) {
        HashMap<String, Object> response = new HashMap<>();
        List<Dtopnp> dtopnp = servicepnp.listadtopnp(peloton);
        if (dtopnp.isEmpty()) {
            response.put("mensaje", "no hay informacion");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dtopnp);
    }

    @PutMapping("/actualizarestadoaocupado/{cip}")
    public ResponseEntity<?> actualizarEstado(@PathVariable String cip) {
        HashMap<String, Object> response = new HashMap<>();
        Pnp efectivo = servicepnp.findByCip(cip);
        if (efectivo == null) {
            response.put("mensaje", "no existe el pnp ingresado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response.put("mensaje", "estado de efectivo actualizado con cip " + cip);
        servicepnp.actualizarestadoaocupado(cip);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PutMapping("/cambiarmobil/{mobil}/{cabeceraid}")
    public ResponseEntity<?> editarpatrulleroencabecera(@PathVariable String mobil, @PathVariable String cabeceraid) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("mensaje", "editado correctamente");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/patrullerosdiponibles")
    public ResponseEntity<List<Dtomobil>> unidadesmobiles() {
        List<Dtomobil> listamobiles = iServicemobil.unidadesmobilesdisponibles();
        return ResponseEntity.status(HttpStatus.OK).body(listamobiles);
    }


    @PutMapping("/updatemobilencabe/{idunidadmobil}/{idcabecerapuesto}")
    public ResponseEntity<?> updatemobilencabecera(@PathVariable Integer idunidadmobil, @PathVariable Integer idcabecerapuesto) {
        HashMap<String, Object> response = new HashMap<>();
        Cabecerapuesto cabecerapuesto = serviciocabecera.findbyidcabecerapuesto(idcabecerapuesto);
        Unidadmobil unidadmobil = iServicemobil.findUnidadmobilbyid(idunidadmobil);
        if (unidadmobil != null && cabecerapuesto != null) {

            serviciocabecera.updatemobilencabecera(idunidadmobil, idcabecerapuesto);
            String mobil = unidadmobil.getDescripcion();
            System.out.println("data ----> " + mobil);

            iServicemobil.updatemobilOcupada(unidadmobil.getDescripcion());
            response.put("mensaje", "se actualizo correctamente");

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("mensaje", "error en los valores selecionados");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PutMapping("/updatemobilDisponible/{mobil}")
    public ResponseEntity<?> updatemobilDisponible(@PathVariable String mobil) {
        Map<String, Object> response = new HashMap<String, Object>();
        Unidadmobil unidadmobil = iServicemobil.findunidadmobilbyDesc(mobil);
        if (unidadmobil != null) {
            iServicemobil.updatemobilDisponible(mobil);
            response.put("mensaje", "la unidad mobil  encuentra disponible");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    @PutMapping("/updatemobilDisponible/")
    public ResponseEntity<?> updatemobilDisponible() {
        Map<String, Object> response = new HashMap<String, Object>();
        List<Dtomobil> listamobiles = iServicemobil.unidadesmobilesdisponibles();
        for (Dtomobil dtomobil : listamobiles) {
            iServicemobil.updatemobilDisponible(dtomobil.getDescripcion());
        }
        response.put("mensaje", "se actualizaron correctamente las unidades mobiles");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/updatepuestoencabe/{idnuevopuesto}/{idcabe}")
    public ResponseEntity<?> updatepuestoencabe(@PathVariable Integer idnuevopuesto, @PathVariable Integer idcabe) {
        HashMap<String, Object> response = new HashMap<>();
        iServicemobil.updatepuestoencabe(idnuevopuesto, idcabe);
        response.put("mensaje", "se actualizo correctamente el puesto en cabecera");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/puestospatrulleros")
    public ResponseEntity<List<Puesto>> puestospatrulleros() {
        List<Puesto> listapuestos = iServiciopuesto.listapuestos();
        return ResponseEntity.status(HttpStatus.OK).body(listapuestos);
    }

    @PutMapping("/eliminarefectivosdecabecera/{idcabe}/{idarea}")
    public ResponseEntity<Void> eliminarcaberaporid(@PathVariable Integer idcabe, @PathVariable Integer idarea) {
        List<Pnp> listpnpbyareaycabe = servicepnp.findbycabecerayarea(idcabe, idarea);
        if (!listpnpbyareaycabe.isEmpty()) {
            System.out.println("se econtro la lista");
            for (Pnp pnp : listpnpbyareaycabe) {
                pnp.setCabecerapuesto(null);
                Estado estado = new Estado();
                estado.setIdestado(1);
                pnp.setEstadopnp(estado);
                servicepnp.savepnp(pnp);
                System.out.println("se actualizo cada pnp cabe con null en cabecera");
            }
        }
        System.out.println("funciono");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/eliminarcabecera/{idcabecera}")
    public ResponseEntity<?> deletecabecera(@PathVariable Integer idcabecera) {
        // Buscar la cabecera por ID
        HashMap<Object, Object> mensaje = new HashMap<>();
        Cabecerapuesto cabe = serviciocabecera.findbyidcabecerapuesto(idcabecera);
        if (cabe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cabecera no encontrada");
        }
        // Verificar si tiene una unidad móvil asociada
        Unidadmobil mobil = cabe.getMobil();
        if (mobil != null) {
            // Cambiar el estado a disponible
            String descripcionMobil = mobil.getDescripcion();
            System.out.println("Descripción de la unidad móvil: " + descripcionMobil);
            iServicemobil.updatemobilDisponible(descripcionMobil); // Actualizar a disponible
            cabe.setMobil(null);
            cabe.setPuesto(null);
            serviciocabecera.anadircabecera(cabe); // Guardar los cambios en la cabecera
        }
        // Verificar si hay PNP asociados a la cabecera
        List<Pnp> pnps = servicepnp.findbycabeceras(idcabecera);
        System.out.println("Contenido de la lista de PNPs para idcabecera " + idcabecera + ": " + pnps);
        if (pnps != null && !pnps.isEmpty()) {
            mensaje.put(mensaje,"Aún hay PNP con el cabeid" + idcabecera + " en algún pelotón");
            return ResponseEntity.status(HttpStatus.OK).body(mensaje);
        }
        // Si no hay PNP asociados, eliminar la cabecera
        serviciocabecera.eliminarcabecera(idcabecera);
        mensaje.put(mensaje,"Se elimino correctanmete toda la cabecera");
        return ResponseEntity.status(HttpStatus.OK).body(mensaje);
    }
}







