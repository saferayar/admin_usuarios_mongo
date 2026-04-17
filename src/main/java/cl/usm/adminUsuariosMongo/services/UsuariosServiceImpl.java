package cl.usm.adminUsuariosMongo.services;

import cl.usm.adminUsuariosMongo.entities.Usuario;
import cl.usm.adminUsuariosMongo.repositories.UsuariosRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;
    @Override
    public Usuario createUser(Usuario usuario) {
        try{
            usuario.setClave(RandomStringUtils.secure().next(10));
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

    @Override
    public List<Usuario> filter(String query) {
        //1. Find all
        List<Usuario> usuarios = this.getAll();
        //2. Streams
        // JDK 8 API Streams
        List<Usuario> filtrados = usuarios.stream()
                .filter(u->u.getNombre().toLowerCase()
                        .contains(query.toLowerCase()) || u.getApellido()
                        .toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        return filtrados;

    }
}
