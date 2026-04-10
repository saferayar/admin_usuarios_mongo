package cl.usm.adminUsuariosMongo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuarios")
public class Usuario implements Serializable {
    @Id
    private String email;
    private String nombre;
    private String apellido;
    private String clave;
}

