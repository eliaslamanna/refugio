package src.Model;

import src.DTO.UsuarioDTO;
import src.Enum.Rol;

import java.util.ArrayList;
import java.util.List;

public class AdapterServicioAutenticacion implements AdapterAutenticacion {

    private static AdapterServicioAutenticacion instance;
    private static List<Usuario> usuarios;

    private AdapterServicioAutenticacion(){
        usuarios = new ArrayList<>();
        inicializarDatos();
    }

    public static AdapterServicioAutenticacion getInstancia(){
        if (instance==null)
            instance = new AdapterServicioAutenticacion();

        return instance;
    }

    public Usuario autenticarUsuario(UsuarioDTO usuarioParaAutenticar){
        return this.getUsuarioPorId(usuarioParaAutenticar.getIdUsuario());
    }

    private Usuario getUsuarioPorId(String id){
        for (Usuario usuario:
                usuarios) {
            if (usuario.getIdUsuario().equals(id))
                return usuario;
            }
        return new Usuario();
    }

    private void inicializarDatos() {
        Usuario usuario;

        usuario = new Usuario("veterinario01", "Pepe", "Veterinario", "00000000000"
                , "unMail01@dominio.com.ar", "99999999", Rol.VETERINARIO, true);

        usuarios.add(usuario);

        usuario = new Usuario("visitador01", "Jose", "Visitador", "1111111111111"
                , "unMail02@dominio.com.ar", "99999998", Rol.VISITADOR, true);

        usuarios.add(usuario);

    }

}
