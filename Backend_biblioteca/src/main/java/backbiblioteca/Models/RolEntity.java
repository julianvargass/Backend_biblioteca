package backbiblioteca.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rol")
@Builder
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID RolId;

    private String RolName;
    @OneToMany(mappedBy = "rol")
    private List<UserEntity> users;
}
