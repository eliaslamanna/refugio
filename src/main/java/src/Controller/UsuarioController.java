package src.Controller;

import src.DTO.UsuarioDTO;
import src.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios;

    private static UsuarioController instancia;

    private UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public static UsuarioController getInstancia() {
        if (instancia == null){
            instancia = new UsuarioController();
        }
        return instancia;
    }

    public Usuario getUsuarioPorId(String id){
        for (Usuario usuario:
             usuarios) {
            if (usuario.getIdUsuario() == id){
                return usuario;
            }
        }
        return null;
    }
}
