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
@Table(name = "user_prestamo")
public class UserPrestamoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userPrestamoId;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "prestamo")
    private PrestamoEntity prestamo_id;
}
