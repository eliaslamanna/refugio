package src.Controller;

import src.DTO.AdoptanteDTO;
import src.DTO.DatosNotificacion;
import src.Model.Adoptante;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdoptanteController {
    private static AdoptanteController instancia;
    private List<Adoptante> adoptantes;

    private AdoptanteController(){
        adoptantes = new ArrayList<>();
    }

    public static AdoptanteController getInstancia() {
        if (instancia == null)
            instancia = new AdoptanteController();
        return instancia;
    }

    public AdoptanteDTO altaAdoptante(AdoptanteDTO adoptante) {
        Adoptante adoptanteParaGuardar = Adoptante.toObject(adoptante);

        if (this.adoptanteYaExiste(adoptanteParaGuardar)) {
            System.out.println("\n El adoptante ya existe en la base de datos\n");
        } else {
            adoptantes.add(adoptanteParaGuardar);
            System.out.println(String.format("Se ingresó el adoptante %s %s exitosamente.", adoptante.getNombre(), adoptante.getApellido()));
        }

        return adoptanteParaGuardar.toDTO();
    }
    private boolean adoptanteYaExiste(Adoptante adoptante) {
        return adoptantes.contains(adoptante);
    }
    public Adoptante buscarAdoptante(String idAdoptante) {
        return adoptantes.stream().filter(adoptante -> adoptante.getId().equals(idAdoptante)).findFirst().orElse(null);
    }

    public DatosNotificacion getDatosDeAdoptante(String id_adoptante) {
        DatosNotificacion datos = null;
        for (Adoptante adoptante : adoptantes) {
            if (adoptante.getId().equals(id_adoptante)) {
                datos = new DatosNotificacion(adoptante.getTelefono(), adoptante.getDireccion(), "Su visita esta proxima a su fecha!");
            }
        }
        return datos;
    }

    public List<AdoptanteDTO> getAdoptantesDisponibles(){
        List <AdoptanteDTO> adoptantesDisponibles = new ArrayList<>();
        for (Adoptante adoptante : adoptantes) {
            if(AdopcionesController.getInstancia().isDisponibleAdoptante(adoptante.getId())){
                adoptantesDisponibles.add(adoptante.toDTO());
            }
        }
        return adoptantesDisponibles;
    }

    public AdoptanteDTO getAdoptantePorId(String idAdoptante) {
        AdoptanteDTO adoptanteDTO = null;

        for (Adoptante adoptante : adoptantes) {
            if (adoptante.getId().equals(idAdoptante))
                adoptanteDTO = adoptante.toDTO();
        }

        return adoptanteDTO;
    }

    public AdoptanteDTO getRandomAdoptante(){
        if (adoptantes.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(adoptantes.size());
        return adoptantes.get(randomIndex).toDTO();
    }

}
