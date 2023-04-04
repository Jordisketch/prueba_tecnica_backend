package Code.Code.mvn.service;

import Code.Code.models.Colaborador;
import Code.Code.models.Estado;
import Code.Code.models.Prioridad;
import Code.Code.models.Tarea;

import java.sql.Date;
import java.util.List;

public interface ITareaService {

    List<Tarea> getAll();
    Tarea save(Tarea entity);
    Boolean delete(Integer id);

    List<Tarea> buscarTareas(
            Date fechaInicio,
            Date fechaFin,
            Integer prioridad,
            Integer estado,
            Integer colaborador,
            String descripcion
    );

}
