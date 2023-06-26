package src.Controller;

import src.DTO.UsuarioDTO;
import src.Enum.Rol;
import src.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private static List<Usuario> usuarios;

    private static UsuarioController instancia;

    private UsuarioController() {
        usuarios = new ArrayList<>();
    }

    public static UsuarioController getInstancia() {
        if (instancia == null){
            instancia = new UsuarioController();
        }
        return instancia;
    }

    public UsuarioDTO getUsuarioPorId(String id) {
        UsuarioDTO usuarioDTO = null;

        for (Usuario usuario :
                usuarios) {
            if (usuario.getIdUsuario().equals(id))
                usuarioDTO = usuario.toDTO();
        }

        return usuarioDTO;
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

    public void agregarUsuario(src.Model.Usuario usuario){
        usuarios.add(usuario);
    }

    public UsuarioDTO autenticarUsuario(UsuarioDTO usuarioParaAutenticar){
        Usuario usuario = Usuario.autenticarUsuario(usuarioParaAutenticar);
        if (usuario.isAutenticado()) {
            usuarios.remove(usuario);
            usuarios.add(usuario);
        }
        return usuario.toDTO();
    }

}
