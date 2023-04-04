package Code.Code.mvn.service.impl;

import Code.Code.dao.IPrioridad;
import Code.Code.models.Prioridad;
import Code.Code.mvn.service.IPrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("prioridadService")
public class PrioridadService implements IPrioridadService {

    @Autowired
    IPrioridad prioridadDao;


    @Override
    public List<Prioridad> getAll() {
        return prioridadDao.findAll();
    }
}
