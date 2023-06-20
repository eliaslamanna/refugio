package src.Controller;

import src.DTO.*;
import src.Model.*;

import java.util.*;


public class AdopcionesController {

    private static List<Adoptante> adoptantes;
    private static List<Adopcion> adopciones;
    private static List<Usuario> visitadores;
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

    public AdoptanteDTO AltaAdoptante(AdoptanteDTO adoptante) {
        Adoptante adoptanteParaGuardar = Adoptante.toObject(adoptante);

        if (this.AdoptanteYaExiste(adoptanteParaGuardar)) {
            System.out.println("\n El adoptante ya existe en la base de datos\n");
        } else {
            adoptantes.add(adoptanteParaGuardar);
            System.out.println(String.format("Se ingresó el adoptante %s %s exitosamente.", adoptante.getNombre(), adoptante.getApellido()));
        }

        return adoptanteParaGuardar.toDTO();
    }
    private boolean AdoptanteYaExiste(Adoptante adoptante) {
        return adoptantes.contains(adoptante);
    }
    public Adoptante buscarAdoptante(String idAdoptante) {
        return adoptantes.stream().filter(adoptante -> adoptante.getId().equals(idAdoptante)).findFirst().orElse(null);
    }

    public void CrearAdopcion(AdoptanteDTO adoptanteDTO, AnimalDTO mascotaDTO, SeguimientoDTO seguimientoDTO){

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
            if (adopcion.getMascota().getId() == idAnimal) {
                adopcionDTO = adopcion.toDTO();
            }
        }
        return adopcionDTO; // Si no se encuentra la adopción con los criterios especificados
    }

    public DatosNotificacion getDatosDeAdoptante(String id_adoptante) {
        for (Adoptante adoptante : adoptantes) {
            if (adoptante.getId() == id_adoptante) {
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
                animales.add(adopcion.getMascota().toDTO());
            }
        }
        return animales;
    }

    public VisitaDTO getUltimaVisitaPorAnimal(String idAnimal){
        VisitaDTO visita = new VisitaDTO();
        for (Adopcion adopcion: adopciones) {
            if (adopcion.getSeguimiento().getContinuarVisitas()){
                return adopcion.getSeguimiento().getUltimaVisita().toDTO();
            }
        }
        return null;
    }

    public UsuarioDTO getResponsableDeSeguimiento(String animalID){
        for (Adopcion adopcion : adopciones) {
            if (animalID == adopcion.getMascota().getId()){
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

    public AdoptanteDTO getAdoptantePorId(String idAdoptante) {
        AdoptanteDTO adoptanteDTO = new AdoptanteDTO(null, null, null, null, null
                , null, 0, null, null);

        for (Adoptante adoptante :
                this.adoptantes) {
            if (adoptante.getId() == idAdoptante)
                adoptanteDTO = adoptante.toDTO();
        }

        return adoptanteDTO;
    }

    public SeguimientoDTO getSeguimientoByAnimal(String idAnimal){
        return this.obtenerAdopcion(idAnimal).getSeguimiento();
    }

    public void terminarVisita(VisitaDTO visita, AnimalDTO mascotaDTO, boolean continuarVisitas){
        Seguimiento seguimiento = null;
        for (Adopcion adopcion : adopciones){
            if (adopcion.getMascota().getId().equals(mascotaDTO.getId())) {
                seguimiento = adopcion.getSeguimiento();
                seguimiento.getUltimaVisita().setEncuesta(visita.getEncuesta());
                seguimiento.getUltimaVisita().setObservaciones(visita.getObservaciones());
                seguimiento.setContinuarVisitas(continuarVisitas);
                if (continuarVisitas){
                    seguimiento.crearProximaVisita();
                }
            }
        }
    }


}