package src.Service;

import src.DTO.UsuarioDTO;
import src.Enum.Rol;
import src.Model.Usuario;

public class UsuarioAutenticado {

    private String idUsuario;

    private String nombre;

    private String apellido;

    private String telefono;

    private String mail;

    private String dni;

    private Rol tipo;

    public UsuarioAutenticado(String idUsuario, String nombre, String apellido, String telefono, String mail, String dni, Rol tipo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.dni = dni;
        this.tipo = tipo;
    }

    public static src.Model.Usuario toObject(UsuarioDTO usuarioDTO) {
        src.Model.Usuario usuario = new src.Model.Usuario(usuarioDTO.getIdUsuario(), usuarioDTO.getNombre(), usuarioDTO.getApellido()
                , usuarioDTO.getTelefono(), usuarioDTO.getMail(), usuarioDTO.getDni(), usuarioDTO.getTipo());

        return usuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    public String getDni() {
        return dni;
    }

    public Rol getTipo() {
        return tipo;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTipo(Rol tipo) {
        this.tipo = tipo;
    }

    public UsuarioDTO toDTO() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIdUsuario(this.idUsuario);
        usuarioDTO.setNombre(this.nombre);
        usuarioDTO.setApellido(this.apellido);
        usuarioDTO.setDni(this.dni);
        usuarioDTO.setTelefono(this.telefono);
        usuarioDTO.setMail(this.mail);
        usuarioDTO.setTipo(this.tipo);

        return usuarioDTO;
    }

}
