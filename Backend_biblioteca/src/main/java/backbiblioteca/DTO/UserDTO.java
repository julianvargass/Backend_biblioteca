package backbiblioteca.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userName;
    private String userLastName;
    private String email;
    private String password;
    private RolDTO roles;
}
