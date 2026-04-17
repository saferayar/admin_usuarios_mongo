package cl.usm.adminUsuariosMongo.services;

import cl.usm.adminUsuariosMongo.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    Usuario createUser(Usuario usuario);
    List<Usuario> getAll();
    Optional<Usuario> findByEmail(String email);
    List<Usuario> filter(String query);
}
