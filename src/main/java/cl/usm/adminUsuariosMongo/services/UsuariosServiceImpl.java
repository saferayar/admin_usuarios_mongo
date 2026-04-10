package cl.usm.adminUsuariosMongo.services;

import cl.usm.adminUsuariosMongo.entities.Usuario;
import cl.usm.adminUsuariosMongo.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;
    @Override
    public Usuario createUser(Usuario usuario) {
        try{
           return  this.usuariosRepository.insert(usuario);
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public List<Usuario> getAll() {
        return this.usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return this.usuariosRepository.findById(email);
    }
}
