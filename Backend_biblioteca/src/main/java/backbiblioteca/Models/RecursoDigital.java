package backbiblioteca.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recursoDigital")
public class RecursoDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID recursoDigitalId;

    private String titulo;
    private String autor;
    private String genero;
    private Date añoPublicacion;
    private int ISBN;
    private String linkDescarga;
    private int stock;

    @OneToMany(mappedBy = "recursoDigital")
    private List<RecursoPrestamo> recursoPrestamos;

    @ManyToOne
    @JoinColumn(name = "tipoRecurso")
    private TipoRecurso tipoRecurso;

    @ManyToOne
    @JoinColumn(name = "recursoBiblioteca")
    private Library biblioteca;

    @OneToMany(mappedBy = "reseñaRecurso")
    private List<Reseña> recursoReseña;
}
