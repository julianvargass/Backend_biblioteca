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
@Table(name = "Preferencia")
public class Preferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID preferenciaId;

    private String autor;
    private String genero;

    @OneToMany(mappedBy = "preferencia")
    private List<PreferenciaUser> preferenciaUsers;
}
