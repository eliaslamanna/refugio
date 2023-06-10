package src.Model;
import src.Controller.AdopcionesController;


public class Adopcion {

    private Adoptante adoptante;

    private Animal mascota;
    
    private Seguimiento seguimiento;


    public Adoptante getAdoptante(){ return this.adoptante;}
    public Animal getAnimal(){ return this.mascota; }



    public Adopcion( String IdAdoptante, String IdAnimal){
        this.adoptante = AdopcionesController.getInstancia().buscarAdoptante(IdAdoptante);
        this.mascota = Refugio.getInstancia().buscarAnimal(IdAnimal);
        this.seguimiento = new Seguimiento();// que deberia generar?

    }




    public void enviarRecordatorio() {
        // TODO implement here
    }

}