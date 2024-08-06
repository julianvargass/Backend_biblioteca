package backbiblioteca.DAO.RolDao;

import backbiblioteca.DTO.RolDTO;
import backbiblioteca.Interfaces.CommunicationInterface;

public interface RolDao {
    CommunicationInterface getRoleByRolName(RolDTO rol);
}
