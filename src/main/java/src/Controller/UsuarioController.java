package src.Controller;

import src.DTO.UsuarioDTO;
import src.Enum.Rol;
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

    public UsuarioDTO getUsuarioPorId(String id){
        for (Usuario usuario:
             usuarios) {
            if (usuario.getIdUsuario() == id){
                return usuario.toDTO();
            } else {
                return new UsuarioDTO();
            }
        }
        return null;
    }

    public List<UsuarioDTO> getUsuariosVeterinarios() {
        List<UsuarioDTO> veterinarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getTipo() == Rol.VETERINARIO) {
                veterinarios.add(usuario.toDTO());
            }
        }
        return veterinarios;
    }
}
