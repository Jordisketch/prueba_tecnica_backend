package Code.Code.mvn.service.impl;

import Code.Code.dao.IEstado;
import Code.Code.dao.IPrioridad;
import Code.Code.models.Estado;
import Code.Code.models.Prioridad;
import Code.Code.mvn.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("estadoService")
public class EstadoService implements IEstadoService {
    @Autowired
    IEstado estadoDao;


    @Override
    public List<Estado> getAll() {
        return estadoDao.findAll();
    }
}
