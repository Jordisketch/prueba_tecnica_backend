package Code.Code.mvn.service.impl;

import Code.Code.dao.ITarea;
import Code.Code.models.Colaborador;
import Code.Code.models.Estado;
import Code.Code.models.Prioridad;
import Code.Code.models.Tarea;
import Code.Code.mvn.service.ITareaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service("tareaService")
public class TareaService implements ITareaService {

    @Autowired
     ITarea tareaDao;

    @Override
    public List<Tarea> getAll() {
        return tareaDao.findAll();
    }

    @Override
    public Tarea save(Tarea entity) {
        return tareaDao.save(entity);
    }

    @Override
    public Boolean delete(Integer id) {
        Tarea tarea = tareaDao.findTareaById(id);

        if(tarea != null && !tarea.getId().equals(0)){
            tarea.setColaborador(null);
            tareaDao.delete(tarea);
            return true;
        }

        return false;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tarea> buscarTareas(
            Date fechaInicio,
            Date fechaFin,
            Integer prioridad,
            Integer estado,
            Integer colaborador,
            String descripcion
    ) {
        String query = "SELECT t FROM Tarea t WHERE ";
        boolean filtro = false;

        if (fechaInicio != null) {
            query += "t.fechainicio >= :fechaInicio ";
            filtro = true;
        }
        if (fechaFin != null) {
            if (filtro) {
                query += "AND ";
            }
            query += "t.fechafin <= :fechaFin ";
            filtro = true;
        }
        if (prioridad != null) {
            if (filtro) {
                query += "AND ";
            }
            query += "t.prioridad.id = :prioridad ";
            filtro = true;
        }
        if (estado != null) {
            if (filtro) {
                query += "AND ";
            }
            query += "t.estado.id = :estado ";
            filtro = true;
        }
        if (colaborador != null) {
            if (filtro) {
                query += "AND ";
            }
            query += "t.colaborador.id = :colaborador ";
            filtro = true;
        }
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            if (filtro) {
                query += "AND ";
            }
            query += "t.descripcion LIKE CONCAT('%', :descripcion, '%')";
        }

        jakarta.persistence.Query q = entityManager.createQuery(query);

        if (fechaInicio != null) {
            q.setParameter("fechaInicio", fechaInicio);
        }
        if (fechaFin != null) {
            q.setParameter("fechaFin", fechaFin);
        }
        if (prioridad != null) {
            q.setParameter("prioridad", prioridad);
        }
        if (estado != null) {
            q.setParameter("estado", estado);
        }
        if (colaborador != null) {
            q.setParameter("colaborador", colaborador);
        }
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            q.setParameter("descripcion", descripcion);
        }

        @SuppressWarnings("unchecked")
        List<Tarea> result = q.getResultList();

        return result;
    }
}
