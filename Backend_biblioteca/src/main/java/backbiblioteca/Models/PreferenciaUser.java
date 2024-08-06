package backbiblioteca.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PreferenciaUser")
public class PreferenciaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "preferencia_user_id")
    private UUID preferenciaUserId;

    @ManyToOne
    @JoinColumn(name = "preferencia_id")
    private Preferencia preferencia;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
