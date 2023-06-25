package src.DTO;

public class AdoptanteDTO {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String nombre;
    private String apellido;
    private String estadoCivil;
    private String direccion;
    private String telefono;
    private String ocupacion;
    private int otrasMascotas;
    private String motivoAdopcion;
    private String tipoAnimalInteresado;


    public AdoptanteDTO(String nombre, String apellido, String estadoCivil, String direccion, String telefono,
                        String ocupacion, int otrasMascotas, String motivoAdopcion, String tipoAnimalInteresado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.otrasMascotas = otrasMascotas;
        this.motivoAdopcion = motivoAdopcion;
        this.tipoAnimalInteresado = tipoAnimalInteresado;
    }

    public AdoptanteDTO(String id, String nombre, String apellido, String estadoCivil, String direccion, String telefono,
                        String ocupacion, int otrasMascotas, String motivoAdopcion, String tipoAnimalInteresado) {
        this(nombre, apellido, estadoCivil, direccion, telefono, ocupacion, otrasMascotas, motivoAdopcion
                , tipoAnimalInteresado);
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getOtrasMascotas() {
        return otrasMascotas;
    }

    public void setOtrasMascotas(int otrasMascotas) {
        this.otrasMascotas = otrasMascotas;
    }

    public String getMotivoAdopcion() {
        return motivoAdopcion;
    }

    public void setMotivoAdopcion(String motivoAdopcion) {
        this.motivoAdopcion = motivoAdopcion;
    }

    public String getTipoAnimalInteresado() {
        return tipoAnimalInteresado;
    }

    public void setTipoAnimalInteresado(String tipoAnimalInteresado) {
        this.tipoAnimalInteresado = tipoAnimalInteresado;
    }




}
