package backbiblioteca.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedNotifications;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {
    private String rolname;
}
