package Code.Code.dao;

import Code.Code.models.Estado;
import Code.Code.models.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("estadoDao")
@Transactional
public interface IEstado extends JpaRepository<Estado, Integer> {
}
