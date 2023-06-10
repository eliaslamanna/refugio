package src.DTO;

import src.Model.Rol;

public class UsuarioDTO {
    private String _nombre;
    private String _apellido;
    private String _telefono;
    private String _email;
    private String _dni;
    private Rol _rol;

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public String get_telefono() {
        return _telefono;
    }

    public void set_telefono(String _telefono) {
        this._telefono = _telefono;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_dni() {
        return _dni;
    }

    public void set_dni(String _dni) {
        this._dni = _dni;
    }

    public Rol get_rol() {
        return _rol;
    }

    public void set_rol(Rol _rol) {
        this._rol = _rol;
    }
}
