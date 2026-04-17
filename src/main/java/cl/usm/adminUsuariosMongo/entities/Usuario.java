package cl.usm.adminUsuariosMongo.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Debe ingresar un correo")
    @Email(message = "El email debe ser valido")
    private String email;

    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;
    @NotBlank
    private String apellido;
    //TODO: Generada, no provista por el usuario, apache common lang
    private String clave;
    private Direccion[] direcciones;
}

