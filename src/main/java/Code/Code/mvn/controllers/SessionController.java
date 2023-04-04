package Code.Code.mvn.controllers;

import Code.Code.models.Session;
import Code.Code.mvn.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class SessionController {

    @Autowired
    private ISessionService sessionService;

    @RequestMapping(value = "/nuevo")
    public ResponseEntity<?> createUser(@RequestBody Session session) {

        if(session.getUsername().equalsIgnoreCase("") || session.getPassword().equalsIgnoreCase("") || session.getEmail().equalsIgnoreCase("")){
            return new ResponseEntity<>("Error al crear el usuario, verifique los datos.", HttpStatus.FORBIDDEN);
        }

        if(sessionService.existUser(session.getEmail())){
            return new ResponseEntity<>("Ya existe un registro con los mismos datos.", HttpStatus.FORBIDDEN);
        };

        session.setPassword(new BCryptPasswordEncoder().encode(session.getPassword()));


        session = sessionService.save(session);

        return new ResponseEntity<>("Usuario creado correctamente.", HttpStatus.OK);
    }

}
