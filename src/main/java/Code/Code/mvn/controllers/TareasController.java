package Code.Code.mvn.controllers;

import Code.Code.models.*;
import Code.Code.mvn.service.IColaboradorService;
import Code.Code.mvn.service.IEstadoService;
import Code.Code.mvn.service.IPrioridadService;
import Code.Code.mvn.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/tareas")
public class TareasController {

    @Autowired
    ITareaService tareaService;

    @Autowired
    IColaboradorService colaboradorService;

    @Autowired
    IEstadoService estadoService;

    @Autowired
    IPrioridadService prioridadService;

    @RequestMapping(value = "/lista")
    public ResponseEntity<List<Tarea>> getListTareas() {
        return new ResponseEntity<>(tareaService.getAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/agregar")
    public ResponseEntity<?> guardarTarea(@RequestBody Tarea tarea) {
        if (!tarea.hasData())
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        tarea = tareaService.save(tarea);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/eliminar/{id}", produces="text/plain")
    public ResponseEntity<?> eliminarTarea(@PathVariable Integer id) {
        if(tareaService.delete(id)){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }


    @RequestMapping(value = "/colaboradores")
    public ResponseEntity<List<Colaborador>> getListColaboradores() {
        return new ResponseEntity<>(colaboradorService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/busqueda")
    public ResponseEntity<List<Tarea>> buscarTareas(
            @RequestParam(name = "fechaInicio", required = false) String fechaInicio,
            @RequestParam(name = "fechaFin", required = false) String  fechaFin,
            @RequestParam(name = "prioridad", required = false) Integer prioridad,
            @RequestParam(name = "estado", required = false) Integer estado,
            @RequestParam(name = "colaborador", required = false) Integer colaborador,
            @RequestParam(name = "descripcion", required = false) String descripcion) {
        Instant fechaInicioInstant = Instant.parse(fechaInicio);
        Instant fechaFinInstant = Instant.parse(fechaFin);

        Date fechaInicioDate = new Date(fechaInicioInstant.toEpochMilli());
        Date fechaFinDate = new Date(fechaFinInstant.toEpochMilli());
        return new ResponseEntity<>(tareaService.buscarTareas(fechaInicioDate, fechaFinDate, prioridad, estado, colaborador, descripcion), HttpStatus.OK);

    }


    @RequestMapping(value = "/prioridades")
    public ResponseEntity<List<Prioridad>> getListPrioridades() {
        return new ResponseEntity<>(prioridadService.getAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/estados")
    public ResponseEntity<List<Estado>> getListEstados() {
        return new ResponseEntity<>(estadoService.getAll(), HttpStatus.OK);
    }

}
