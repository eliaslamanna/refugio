package src.Model;

import src.Enum.Rol;
import src.DTO.UsuarioDTO;


public class Usuario {

    private String idUsuario;

    private String nombre;

    private String apellido;

    private String telefono;

    private String mail;

    private String dni;

    private Rol tipo;
    private boolean autenticado;

    public Usuario(){}
    public Usuario(String idUsuario, String nombre, String apellido, String telefono, String mail, String dni, Rol tipo, boolean autenticado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.dni = dni;
        this.tipo = tipo;
        this.autenticado = autenticado;
    }

    public static Usuario toObject(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.getIdUsuario(), usuarioDTO.getNombre(), usuarioDTO.getApellido()
                , usuarioDTO.getTelefono(), usuarioDTO.getMail(), usuarioDTO.getDni(), usuarioDTO.getTipo(),usuarioDTO.isAutenticado());

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
        UsuarioDTO usuarioDTO = new UsuarioDTO(this.idUsuario,this.nombre,this.apellido,this.telefono,this.mail
                ,this.dni,this.tipo,this.autenticado);

        return usuarioDTO;
    }

    public static Usuario autenticarUsuario(UsuarioDTO usuario){
        return AdapterServicioAutenticacion.getInstancia().autenticarUsuario(usuario);
    }

}