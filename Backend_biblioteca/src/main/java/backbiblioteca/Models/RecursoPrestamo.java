package backbiblioteca.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recursoPrestamo")
public class RecursoPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID recursoPrestamoId;

    @ManyToOne
    @JoinColumn(name = "prestamo")
    private PrestamoEntity prestamo_id;

    @ManyToOne
    @JoinColumn(name = "recursoDigital")
    private RecursoDigital recursoDigital;
}
