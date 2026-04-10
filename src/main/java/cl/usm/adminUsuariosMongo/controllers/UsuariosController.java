package cl.usm.adminUsuariosMongo.controllers;

import cl.usm.adminUsuariosMongo.entities.Usuario;
import cl.usm.adminUsuariosMongo.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAll(){
        try{
            List<Usuario> usuarios = this.usuariosService.getAll();
            return ResponseEntity.ok(usuarios);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> createUser(@RequestBody Usuario usuario){
        Usuario res= this.usuariosService.createUser(usuario);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.internalServerError().build();
    }
    // /usuarios/sarayar@asd.cl
    @GetMapping("/usuarios/{email}")
    public ResponseEntity<?> findByEmail( @PathVariable String email){
        return null;
    }
}
