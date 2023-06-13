package src.Controller;

import src.DTO.AdoptanteDTO;
import src.DTO.AnimalDTO;
import src.DTO.UsuarioDTO;
import src.DTO.VisitaDTO;
import src.Model.*;

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


    public void CrearAdopcion(String idadoptante, String idmascota, int cadenciaVisita, String medioRecordatorio, int diasRecordatorio, String idVisitador){
        Usuario resposableSeguimiento = SeguimientoController.getInstancia().getVisitador(idVisitador);
        Adopcion adopcionParaGuardar = new Adopcion(idadoptante, idmascota,cadenciaVisita, medioRecordatorio, diasRecordatorio, resposableSeguimiento);
        adopciones.add(adopcionParaGuardar);
        HistoriaClinica historia =  ClinicaController.getInstancia().buscarHistoriaClinicaXAnimal(idmascota);
        historia.setVisitasADomicilio(adopcionParaGuardar.getSeguimiento());
    }


    public Adopcion obtenerAdopcion(String idAnimal) {
        for (Adopcion adopcion : adopciones) {
            if (adopcion.getAnimal().getId() == idAnimal) {
                return adopcion;
            }
        }
        return null; // Si no se encuentra la adopción con los criterios especificados
    }
    public DatosNotificacion getDatosDeAdoptante(String id_adoptante){
        for (Adoptante adoptante:
             adoptantes) {
            if (adoptante.getId() == id_adoptante){
                DatosNotificacion datos = new DatosNotificacion(adoptante.getTelefono(), adoptante.getDireccion(), "Su visita esta proxima a su fecha!");
                return datos;
            }
        }
        return null;
    }

    public boolean isDisponibleAdoptante(String idadoptante){
        int contador = 0;
        for (Adopcion adopcion : adopciones) {
            if (adopcion.getAdoptante().getId().equals(idadoptante)) {
                contador++;
                if (contador == 2) {
                    return false;
                }
            }
        }
        return true;
    }
    public List<Adoptante> getaAdoptantesDisponibles(){
        List <Adoptante> adoptantesDisponibles = new ArrayList<>();
        for (Adoptante adoptante : adoptantes) {
            if(isDisponibleAdoptante(adoptante.getId())){
                adoptantesDisponibles.add(adoptante);
            }
        }
        return adoptantesDisponibles;
    }

    public List<AnimalDTO> getAnimalesConSeguimientoActivo(){
        ArrayList<AnimalDTO> animales = new ArrayList<>();
        for (Adopcion adopcion:
             adopciones) {
            if (adopcion.getSeguimiento().getContinuarVisitas()){
                animales.add(adopcion.getAnimal().toDTO());
            }
        }
        return animales;
    }

    public VisitaDTO getUltimaVisitaPorAnimal(String idAnimal){
        VisitaDTO visita = new VisitaDTO();
        for (Adopcion adopcion:
                adopciones) {
            if (adopcion.getSeguimiento().getContinuarVisitas()){
                return adopcion.getSeguimiento().getUltimaVisita().toDTO();
            }
        }
        return null;
    }

    public UsuarioDTO getResponsableDeSeguimiento(String animalID){
        for (Adopcion adopcion :
                adopciones) {
            if (animalID == adopcion.getAnimal().getId()){
                return adopcion.getSeguimiento().getResponsable().toDTO();
            }
        }
        return null;
    }
    public void enviarRecordatorio(String idVisitador) {
        for (Adopcion adopcion : adopciones){
            if (adopcion.getSeguimiento().getResponsable().equals(UsuarioController.getInstancia().getUsuarioPorId(idVisitador))){
                DatosNotificacion datos = new DatosNotificacion(adopcion.getAdoptante().getTelefono(),adopcion.getAdoptante().getDireccion(), adopcion.mensajeNotificacion());
                adopcion.getSeguimiento().enviarRecordatorio(datos);
            }

        }
    }

}