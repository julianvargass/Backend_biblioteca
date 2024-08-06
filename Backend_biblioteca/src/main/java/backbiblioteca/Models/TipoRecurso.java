package backbiblioteca.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipoRecurso")
public class TipoRecurso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID tipoRecursoId;
    private String tipoRecurso;

    @OneToMany(mappedBy = "tipoRecurso")
    private List<RecursoDigital> recursoDigital;
}
