package backbiblioteca.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pirulo_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;
    @Column
    private String userName;
    private String userLastName;
    private String email;
    private String phone;
    private String password;

    @ManyToOne
    @JoinColumn(name = "rol")
    private RolEntity rol;

    @OneToMany(mappedBy = "user")
    private List<UserPrestamoEntity> Prestamos;

    @OneToMany(mappedBy = "user")
    private List<PreferenciaUser> preferenciaUsers;
}
