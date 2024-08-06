package backbiblioteca.Utils;

import backbiblioteca.Interfaces.CommunicationInterface;
import backbiblioteca.DAO.User.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class UserDetailServiceImplement implements UserDetailsService {

    @Autowired
    UserInterface userInterface;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CommunicationInterface userFound = userInterface.getUserByEmail(email);
        if(!userFound.getSuccessful()){
            return (UserDetails) new UsernameNotFoundException(userFound.getMessage());
        }
        String password = userFound.getData().get("password").toString();
        String emailFound = userFound.getData().get("email").toString();
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        String rolFound = userFound.getData().get("rol").toString();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + rolFound));
        return new User(emailFound, password, true, true, true, true,
                authorities);
    }
}
