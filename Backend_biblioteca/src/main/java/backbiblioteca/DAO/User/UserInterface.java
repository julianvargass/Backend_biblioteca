package backbiblioteca.DAO.User;

import backbiblioteca.Interfaces.CommunicationInterface;
import backbiblioteca.Models.UserEntity;

public interface UserInterface{
    CommunicationInterface getUserByEmail(String email);

    CommunicationInterface register(UserEntity user);
}
