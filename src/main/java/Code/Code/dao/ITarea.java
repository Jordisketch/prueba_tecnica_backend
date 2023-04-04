package Code.Code.dao;

import Code.Code.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("tareaDao")
@Transactional
public interface ITarea extends JpaRepository<Tarea, Integer> {

    Tarea findTareaById(Integer id);

}
