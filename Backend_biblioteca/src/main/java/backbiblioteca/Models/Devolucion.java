package backbiblioteca.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "devolucion")
public class Devolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID devolucionId;

    private LocalDateTime fechaDevolucion;
    private String novedad;

    @OneToOne(mappedBy = "devolucion")
    private PrestamoEntity prestamo;
}
