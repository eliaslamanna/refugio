package src.Model;

import src.DTO.AdoptanteDTO;
import src.Refugio;

import java.util.UUID;

public class Adoptante {

    private String nombre;
    private String apellido;
    private String estadoCivil;
    private String direccion;
    private String telefono;
    private String ocupacion;
    private int otrasMascotas;
    private String motivoAdopcion;
    private String tipoAnimalInteresado;
    private String Id;

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
    public String getId(){ return Id; }

    public Adoptante(String nombre, String apellido, String estadoCivil, String direccion, String telefono,
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
        Id = UUID.randomUUID().toString();
    }


    public Adoptante(){

    }


    public void AltaAdoptante(AdoptanteDTO adoptante) {
        Adoptante adoptanteParaGuardar = new Adoptante(adoptante.getNombre(), adoptante.getApellido(), adoptante.getEstadoCivil(),
                adoptante.getDireccion(), adoptante.getTelefono(), adoptante.getOcupacion(), adoptante.getOtrasMascotas(),
                adoptante.getMotivoAdopcion(), adoptante.getTipoAnimalInteresado());

        if (Refugio.getInstancia().AdoptanteYaExiste(adoptanteParaGuardar)) {
            System.out.println("\n El adoptante ya existe en la base de datos\n");
        } else {
            Refugio.getInstancia().IngresarAdoptante(adoptanteParaGuardar);
            System.out.println(String.format("Se ingresó el adoptante %s %s exitosamente.", adoptante.getNombre(), adoptante.getApellido()));
        }
    }

    public Adoptante buscarAdoptante(String idAdoptante) {
        Adoptante adoptanteBuscado = Refugio.getInstancia().buscarAdoptante(idAdoptante);
        if (adoptanteBuscado == null) {
            System.out.println(String.format("No se encontró el adoptante con ID %s.", idAdoptante));
        }
        return adoptanteBuscado;
    }
}