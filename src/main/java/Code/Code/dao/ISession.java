package Code.Code.dao;

import Code.Code.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository("sessionDao")
@Transactional
public interface ISession extends JpaRepository<Session, Integer> {

    Optional<Session> findByEmail(String email);


    Boolean existsByEmail(String email);

}
