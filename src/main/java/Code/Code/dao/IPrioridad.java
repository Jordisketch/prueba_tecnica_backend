package Code.Code.dao;

import Code.Code.models.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("prioridadDao")
@Transactional
public interface IPrioridad extends JpaRepository<Prioridad, Integer> {

}
