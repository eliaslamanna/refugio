package src.Controller;

import src.DTO.AdoptanteDTO;
import src.Model.Adopcion;
import src.Model.Adoptante;

import java.util.*;


public class AdopcionesController {

    private static List<Adoptante> adoptantes;

    private static List<Adopcion> adopciones;

    private static AdopcionesController instancia;

    private AdopcionesController() {
        this.adopciones = new ArrayList<>();
        this.adoptantes = new ArrayList<>();
    }

    public static AdopcionesController getInstancia() {
        if(instancia == null) {
            instancia = new AdopcionesController();
        }

        return instancia;
    }

    public void AltaAdoptante(AdoptanteDTO adoptante) {
        Adoptante adoptanteParaGuardar = new Adoptante(adoptante.getNombre(), adoptante.getApellido(), adoptante.getEstadoCivil(),
                adoptante.getDireccion(), adoptante.getTelefono(), adoptante.getOcupacion(), adoptante.getOtrasMascotas(),
                adoptante.getMotivoAdopcion(), adoptante.getTipoAnimalInteresado());

        if (this.AdoptanteYaExiste(adoptanteParaGuardar)) {
            System.out.println("\n El adoptante ya existe en la base de datos\n");
        } else {
            adoptantes.add(adoptanteParaGuardar);
            System.out.println(String.format("Se ingresó el adoptante %s %s exitosamente.", adoptante.getNombre(), adoptante.getApellido()));
        }
    }
    public boolean AdoptanteYaExiste(Adoptante adoptante) {
        return adoptantes.contains(adoptante);
    }
    public Adoptante buscarAdoptante(String idAdoptante) {
        return adoptantes.stream().filter(adoptante -> adoptante.getId().equals(idAdoptante)).findFirst().orElse(null);
    }


    public void CrearAdopcion( String idadoptante, String idmascota){

        Adopcion adopcionParaGuardar = new Adopcion(idadoptante, idmascota);
        if (adopcionParaGuardar.getAnimal().getenTratamiento()) {
            System.out.println("Error: La mascota no está disponible para adopción.");
            return;
        } else if (adopcionParaGuardar.getAdoptante().getOtrasMascotas() >= 2){
            System.out.println("Este adoptante ya adoptó mas de 2 mascotas");


        }
        else {
            adopciones.add(adopcionParaGuardar);
        }


    }

        public void enviarRecordatorio() {
        // TODO implement here
    }

}