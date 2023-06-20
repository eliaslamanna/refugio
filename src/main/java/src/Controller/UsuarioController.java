package src.Controller;

import src.DTO.UsuarioDTO;
import src.Enum.Rol;
import src.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<src.Model.Usuario> usuarios;

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

    public UsuarioDTO getUsuarioPorId(String id) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(null, null, null, null, null
                , null, null, false);

        for (Usuario usuario :
                usuarios) {
            if (usuario.getIdUsuario() == id)
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
        this.usuarios.add(usuario);
    }

    public UsuarioDTO autenticarUsuario(UsuarioDTO usuarioParaAutenticar){
        return this.getUsuarioPorId(usuarioParaAutenticar.getIdUsuario());
    }

}
