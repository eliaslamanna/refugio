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
    private boolean estaAutenticado;

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

    public void setEstaAutenticado(boolean estaAutenticado) { this.estaAutenticado = estaAutenticado; }

    public boolean isEstaAutenticado() {
        return estaAutenticado;
    }
}
