package Code.Code.mvn.service.impl;

import Code.Code.dao.IColaborador;
import Code.Code.models.Colaborador;
import Code.Code.models.Tarea;
import Code.Code.mvn.service.IColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("colaboradorService")
public class ColaboradorService implements IColaboradorService {

    @Autowired
    IColaborador colaboradorDao;

    @Override
    public List<Colaborador> getAll() {
        return colaboradorDao.findColaboradorByNombreIsNotEmpty();
    }
}
