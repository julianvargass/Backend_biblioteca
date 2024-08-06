package backbiblioteca.DAO.RolDao;

import backbiblioteca.DTO.RolDTO;
import backbiblioteca.Interfaces.CommunicationInterface;
import backbiblioteca.Models.RolEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Transactional
public class RolDaoImplement implements RolDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public CommunicationInterface getRoleByRolName(RolDTO rol) {
        try {
            String query = "SELECT r FROM RolEntity r WHERE r.RolName = :rolName";
            RolEntity rolEntity = em.createQuery(query, RolEntity.class)
                    .setParameter("rolName", rol.getRolname())
                    .getSingleResult();
            Map<String, Object> rolFound = new HashMap<>();
            rolFound.put("rolId", rolEntity.getRolId());
            rolFound.put("rolName", rolEntity.getRolName());
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Rol found successfully").setData(rolFound).build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setSuccessful(false).setMessage("Rol could not be found").setData(null).build();
        }
    }
}
