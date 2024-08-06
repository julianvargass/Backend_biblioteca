package backbiblioteca.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prestamo")
public class PrestamoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID PrestamoId;

    private LocalDateTime fechaPrestamo;
    private LocalDateTime plazoEntrega;
    private int cantidadPrestamo;

    @OneToMany(mappedBy = "prestamo_id")
    private List<UserPrestamoEntity> userPrestamo;

    @OneToOne
    @JoinColumn(name = "devolucion")
    private Devolucion devolucion;

    @OneToMany(mappedBy = "prestamo_id")
    private List<RecursoPrestamo> recursoPrestamo;
}
