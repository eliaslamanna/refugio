package src.Service;

import src.Controller.UsuarioController;
import src.DTO.UsuarioDTO;
import src.Enum.Rol;
import src.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AutenticacionService {

    private static AutenticacionService instance;
    private List<UsuarioDTO> usuarios;

    private AutenticacionService(){
        usuarios = new ArrayList<>();
        inicializarDatos();
    }

    public static AutenticacionService getInstance(){
        if (instance==null)
            instance = new AutenticacionService();

        return instance;
    }

    public UsuarioDTO autenticarUsuario(UsuarioDTO usuarioParaAutenticar){

        return this.getUsuarioPorId(usuarioParaAutenticar.getIdUsuario());
    }

    private UsuarioDTO getUsuarioPorId(String id){
        for (UsuarioDTO usuario:
                usuarios) {
            if (usuario.getIdUsuario().equals(id))
                return usuario;
            }
        return new UsuarioDTO();
    }

    private void inicializarDatos() {
        UsuarioDTO usuario;

        usuario = new UsuarioDTO();
        usuario.setIdUsuario("veterinario01");
        usuario.setNombre("Pepe");
        usuario.setApellido("Veterinario");
        usuario.setTelefono("00000000000");
        usuario.setMail("unMail01@dominio.com.ar");
        usuario.setDni("99999999");
        usuario.setTipo(Rol.VETERINARIO);
        usuario.setEstaAutenticado(true);

        this.usuarios.add(usuario);

        usuario = new UsuarioDTO();
        usuario.setIdUsuario("visitador01");
        usuario.setNombre("Jose");
        usuario.setApellido("Visitador");
        usuario.setTelefono("1111111111111");
        usuario.setMail("unMail02@dominio.com.ar");
        usuario.setDni("99999998");
        usuario.setTipo(Rol.VISITADOR);
        usuario.setEstaAutenticado(true);

        this.usuarios.add(usuario);

    }

    public List<UsuarioDTO> getUsuariosVeterinarios() {
        List<UsuarioDTO> veterinarios = new ArrayList<>();
        for (UsuarioDTO usuario : usuarios) {
            if (usuario.getTipo() == Rol.VETERINARIO) {
                veterinarios.add(usuario);
            }
        }
        return veterinarios;
    }
}
