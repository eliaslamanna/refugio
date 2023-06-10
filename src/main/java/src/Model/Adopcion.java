package src.Model;
import src.DTO.AdoptanteDTO;
import src.DTO.AnimalDTO;
import src.Refugio;




public class Adopcion {

    private Adoptante adoptante;

    private Animal mascota;
    
    private Seguimiento seguimiento;

    Adopcion( String IdAdoptante, String IdAnimal){
        this.adoptante = Refugio.getInstancia().buscarAdoptante(IdAdoptante);
        this.mascota = Refugio.getInstancia().buscarAnimal(IdAnimal);
        this.seguimiento = new Seguimiento();// que deberia generar?

    }

    public void CrearAdopcion( String idadoptante, String idmascota){

        Adopcion adopcionParaGuardar = new Adopcion(idadoptante, idmascota);
        if (mascota.getenTratamiento()) {
            System.out.println("Error: La mascota no está disponible para adopción.");
            return;
        } else if (adoptante.getOtrasMascotas() >= 2){
            System.out.println("Este adoptante ya adoptó mas de 2 mascotas");


        }
        else {
            Refugio.getInstancia().AltaAdopcion(adopcionParaGuardar);
        }




    }

    public void enviarRecordatorio() {
        // TODO implement here
    }

}