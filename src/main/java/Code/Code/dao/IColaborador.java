package Code.Code.dao;

import Code.Code.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("colaboradorDao")
@Transactional
public interface IColaborador extends JpaRepository<Colaborador, Integer> {

    @Query("Select c from Colaborador c where c.nombre != '' and c.nombre != null")
    List<Colaborador> findColaboradorByNombreIsNotEmpty();
}
