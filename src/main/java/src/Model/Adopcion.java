package src.Model;
import src.Controller.AdopcionesController;
import src.DTO.AdopcionDTO;
import src.DTO.DatosNotificacion;


public class Adopcion {

    private Adoptante adoptante;
    private Animal mascota;
    private Seguimiento seguimiento;


    public Adoptante getAdoptante(){ return this.adoptante;}
    public Animal getMascota(){ return this.mascota; }



    public Adopcion( Adoptante adoptante, Animal mascota, Seguimiento seguimiento){
        this.adoptante = adoptante;
        this.mascota = mascota;
        this.seguimiento = seguimiento;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }


    public static DatosNotificacion getDatosDeAdoptante(String id_adoptante){
        return AdopcionesController.getInstancia().getDatosDeAdoptante(id_adoptante);
    }

    public String mensajeNotificacion(){
        return " Notificacion para: " + getAdoptante().getNombre() + " " + getAdoptante().getApellido() + " y " + getSeguimiento().getResponsable().getNombre() + " " + getSeguimiento().getResponsable().getNombre() + " // " +  getMascota().getNombre() + " sera visitado el dia " + getSeguimiento().getUltimaVisita().getFechaVisita().toString();
    }

    public AdopcionDTO toDTO(){
        return new AdopcionDTO(
                this.adoptante.toDTO()
                , this.mascota.toDTO()
                , this.seguimiento.toDTO());
    }

}