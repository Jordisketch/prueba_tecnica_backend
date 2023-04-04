package Code.Code.mvn.service.impl;

import Code.Code.dao.ISession;
import Code.Code.models.Session;
import Code.Code.mvn.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "sessionService")
public class SessionService implements ISessionService {

    @Autowired
    private ISession sessionDao;

    @Override
    public Optional<Session> findByEmail(String email) {
        return sessionDao.findByEmail(email);
    }


    @Override
    public Session save(Session entity) {
        return sessionDao.save(entity);
    }


    @Override
    public Boolean existUser(String email) {
        return sessionDao.existsByEmail(email);
    }
}
