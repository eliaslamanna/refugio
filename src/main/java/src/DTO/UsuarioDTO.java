package src.DTO;

import src.Enum.Rol;

public class UsuarioDTO {
    private String idUsuario;

    private String nombre;

    private String apellido;

    private String telefono;

    private String mail;

    private String dni;

    private Rol tipo;
    private boolean autenticado;
    public UsuarioDTO(String idUsuario, String nombre, String apellido, String telefono, String mail, String dni, Rol tipo, boolean autenticado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.dni = dni;
        this.tipo = tipo;
        this.autenticado = autenticado;
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

    public boolean isAutenticado() {
        return autenticado;
    }

}
