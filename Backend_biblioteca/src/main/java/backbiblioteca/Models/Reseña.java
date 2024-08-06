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
@Table(name = "reseña")
public class Reseña {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID reseñaId;

    private String reseña;
    private int calificacion;

    @ManyToOne
    @JoinColumn(name = "recurso")
    private RecursoDigital reseñaRecurso;
}
