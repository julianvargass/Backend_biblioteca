package backbiblioteca.Controller;

import backbiblioteca.Interfaces.CommunicationInterface;
import backbiblioteca.DAO.RolDao.RolDao;
import backbiblioteca.DAO.User.UserInterface;
import backbiblioteca.DTO.UserDTO;
import backbiblioteca.Models.RolEntity;
import backbiblioteca.Models.UserEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserInterface userInterface;

    @Autowired
    RolDao rolDao;

    @PostMapping("createuser")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO){
        CommunicationInterface rolFound = rolDao.getRoleByRolName(userDTO.getRoles());
        String rol = rolFound.getData().get("rolName").toString();
        UserEntity userEntity = UserEntity.builder()
                .userName(userDTO.getUserName())
                .userLastName(userDTO.getUserLastName())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .rol(RolEntity.builder().RolName(rol).build())
                .build();
        userInterface.register(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    /*@PostMapping("createRol")
    public ResponseEntity<?> createRol(@Valid @RequestBody RolDTO rolDTO){
        RolEntity rol = RolEntity.builder()
                .RolName(rolDTO.getRolname())
                .build();
        rolDao.save(rol);
        return ResponseEntity.ok(rol);
    }*/
}
