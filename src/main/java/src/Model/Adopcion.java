package src.Model;
import src.Controller.AdopcionesController;
import src.Controller.AnimalController;


public class Adopcion {

    private Adoptante adoptante;

    private Animal mascota;
    
    private Seguimiento seguimiento;


    public Adoptante getAdoptante(){ return this.adoptante;}
    public Animal getAnimal(){ return this.mascota; }



    public Adopcion( String IdAdoptante, String IdAnimal, int cadenciaVisita, EstrategiaNotificacion estrategia, int diasRecordatorio){
        Seguimiento newSeguimiento = new Seguimiento(// TODO como setear visitador? ,cadenciaVisita, estrategia, diasRecordatorio);
        this.adoptante = AdopcionesController.getInstancia().buscarAdoptante(IdAdoptante);
        this.mascota = AnimalController.getInstancia().buscarAnimal(IdAnimal);
        this.seguimiento = newSeguimiento;
    }


    public Seguimiento getSeguimiento() {
        return seguimiento;
    }


    public static DatosNotificacion getDatosDeAdoptante(String id_adoptante){
        return AdopcionesController.getInstancia().getDatosDeAdoptante(id_adoptante);
    }

}