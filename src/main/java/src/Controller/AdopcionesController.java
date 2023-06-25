package src.Controller;

import src.DTO.*;
import src.Enum.TipoAnimal;
import src.Model.*;

import java.util.*;


public class AdopcionesController {

    private static List<Adoptante> adoptantes;
    private static List<Adopcion> adopciones;
    private static List<Usuario> visitadores;
    private static AdopcionesController instancia;

    private AdopcionesController() {
        adopciones = new ArrayList<>();
        adoptantes = new ArrayList<>();
    }

    public static AdopcionesController getInstancia() {
        if(instancia == null) {
            instancia = new AdopcionesController();
        }
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

    public void crearAdopcion(AdoptanteDTO adoptanteDTO, AnimalDTO mascotaDTO, SeguimientoDTO seguimientoDTO){

        Seguimiento seguimiento = Seguimiento.toObject(seguimientoDTO);

        Adopcion adopcionParaGuardar = new Adopcion(Adoptante.toObject(adoptanteDTO)
                , Animal.toObject(mascotaDTO)
                , seguimiento);
        adopciones.add(adopcionParaGuardar);

        //agregamos el nuevo seguimiento en la historia clínica
        HistoriaClinica historia =  ClinicaController.getInstancia().buscarHistoriaClinicaXAnimal(mascotaDTO.getId());
        historia.setVisitasADomicilio(seguimiento);
    }

    public AdopcionDTO obtenerAdopcion(String idAnimal) {
        AdopcionDTO adopcionDTO = null;
        for (Adopcion adopcion : adopciones) {
            if (adopcion.getMascota().getId().equals(idAnimal)) {
                adopcionDTO = adopcion.toDTO();
            }
        }
        return adopcionDTO; // Si no se encuentra la adopción con los criterios especificados
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

    public boolean isDisponibleAdoptante(String idAdoptante){
        int contador = 0;
        for (Adopcion adopcion : adopciones) {
            if (adopcion.getAdoptante().getId().equals(idAdoptante)) {
                contador++;
                if (contador == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<AdoptanteDTO> getAdoptantesDisponibles(){
        List <AdoptanteDTO> adoptantesDisponibles = new ArrayList<>();
        for (Adoptante adoptante : adoptantes) {
            if(isDisponibleAdoptante(adoptante.getId())){
                adoptantesDisponibles.add(adoptante.toDTO());
            }
        }
        return adoptantesDisponibles;
    }

    public List<AnimalDTO> getAnimalesConSeguimientoActivo(){
        ArrayList<AnimalDTO> animales = new ArrayList<>();
        for (Adopcion adopcion:
             adopciones) {
            if (adopcion.getSeguimiento().getContinuarVisitas()){
                animales.add(adopcion.getMascota().toDTO());
            }
        }
        return animales;
    }

    public VisitaDTO getUltimaVisitaPorAnimal(String idAnimal) {
        VisitaDTO visita = new VisitaDTO();
        for (Adopcion adopcion : adopciones) {
            if (adopcion.getMascota().getId().equals(idAnimal))
                if (adopcion.getSeguimiento().getContinuarVisitas()) {
                    visita = adopcion.getSeguimiento().getUltimaVisita().toDTO();
                }
        }
        return visita;
    }

    public UsuarioDTO getResponsableDeSeguimiento(String idAnimal){
        for (Adopcion adopcion : adopciones) {
            if (adopcion.getMascota().getId().equals(idAnimal)){
                return adopcion.getSeguimiento().getResponsable().toDTO();
            }
        }
        return null;
    }
    public void enviarRecordatorio(String idVisitador) {
        for (Adopcion adopcion : adopciones){
            if (adopcion.getSeguimiento().getResponsable().getIdUsuario().equals(idVisitador)){
                DatosNotificacion datos = new DatosNotificacion(adopcion.getAdoptante().getTelefono(),adopcion.getAdoptante().getDireccion(), adopcion.mensajeNotificacion());
                adopcion.getSeguimiento().enviarRecordatorio(datos);
            }

        }
    }

    public AdoptanteDTO getAdoptantePorId(String idAdoptante) {
        AdoptanteDTO adoptanteDTO = new AdoptanteDTO(null, null, null, null, null
                , null, 0, null, null);

        for (Adoptante adoptante : adoptantes) {
            if (adoptante.getId().equals(idAdoptante))
                adoptanteDTO = adoptante.toDTO();
        }

        return adoptanteDTO;
    }

    public void registrarVisita(VisitaDTO visita, AnimalDTO mascotaDTO, boolean continuarVisitas){
        Seguimiento seguimiento;
        for (Adopcion adopcion : adopciones){
            if (adopcion.getMascota().getId().equals(mascotaDTO.getId())) {
                seguimiento = adopcion.getSeguimiento();
                seguimiento.getUltimaVisita().setEncuesta(visita.getEncuesta());
                seguimiento.getUltimaVisita().setObservaciones(visita.getObservaciones());
                seguimiento.getUltimaVisita().setTerminada(visita.isTerminada());
                seguimiento.setContinuarVisitas(continuarVisitas);
                if (continuarVisitas){
                    seguimiento.crearProximaVisita();
                }
            }
        }
    }

    public List<AnimalDTO> getMascotasDisponiblesParaAdopcion(){
        List<AnimalDTO> mascotasAdoptables = new ArrayList<>();
        boolean isAdoptable = true;

        for (AnimalDTO animalDTO : AnimalController.getInstancia().getAnimales()){
            if (animalDTO.getTipoAnimal().equals(TipoAnimal.DOMESTICO)
                    && !animalDTO.getEnTratamiento()){
                for (Adopcion adopcion : adopciones){
                    if (adopcion.getMascota().getId().equals(animalDTO.getId())){
                        isAdoptable = false;
                    }
                }
                if (isAdoptable)
                    mascotasAdoptables.add(animalDTO);
            }
            isAdoptable = true;
        }

        return mascotasAdoptables;
    }
}