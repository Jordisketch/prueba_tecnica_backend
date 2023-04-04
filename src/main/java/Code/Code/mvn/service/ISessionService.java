package Code.Code.mvn.service;

import Code.Code.models.Session;

import java.util.Optional;

public interface ISessionService {

    Optional<Session> findByEmail(String user);

    Session save(Session entity);

    Boolean existUser(String email);

}
