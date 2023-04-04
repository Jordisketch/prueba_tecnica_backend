package Code.Code.config;

import Code.Code.models.Session;
import Code.Code.mvn.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private ISessionService sessionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Session session =  sessionService
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));

        return new UserDetailsImpl(session);
    }

}
