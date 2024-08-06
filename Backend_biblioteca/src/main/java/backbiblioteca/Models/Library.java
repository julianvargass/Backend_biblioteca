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
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bibliotecaId;

    private String nombre;
    private String direccion;
    private int telefono;
    private String email;

    @OneToMany(mappedBy = "biblioteca")
    private List<RecursoDigital> recursoBiblioteca;
}
