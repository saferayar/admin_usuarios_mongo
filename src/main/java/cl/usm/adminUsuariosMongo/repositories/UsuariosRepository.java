package cl.usm.adminUsuariosMongo.repositories;

import cl.usm.adminUsuariosMongo.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuariosRepository extends MongoRepository<Usuario, String> {
}
