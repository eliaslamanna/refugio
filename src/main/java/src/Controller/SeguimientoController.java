package src.Controller;

import src.DTO.VisitaDTO;
import src.Model.DatosNotificacion;
import src.Model.Seguimiento;
import src.Model.Usuario;

import java.util.*;




public class SeguimientoController {

    private List<Seguimiento> seguimientos;

    private static SeguimientoController instancia;

    private SeguimientoController() {
        this.seguimientos = new ArrayList<>();
    }

    public static SeguimientoController getInstancia() {
        if(instancia == null) {
            instancia = new SeguimientoController();
        }

        return instancia;
    }

    public void enviarRecordatorio(String id_adoptante) {
        for (Seguimiento seguimiento : seguimientos){
            DatosNotificacion datos = seguimiento.getDatosAdoptante(id_adoptante);
            seguimiento.enviarRecordatorio(datos);
        }
    }
    public Usuario getVisitador(String idVisitador){
        for (Seguimiento seguimiento:
         this.seguimientos) {
            if (idVisitador == seguimiento.getResponsable().getIdUsuario()){
                return seguimiento.getResponsable();
            }
        }
        return null;
    }

    public Seguimiento getSeguimientoByAnimal(String idAnimal){
        AdopcionesController adopciones = AdopcionesController.getInstancia();
        for (Seguimiento seguimiento:
             this.seguimientos) {
            if (adopciones.obtenerAdopcion(idAnimal).getSeguimiento() == seguimiento){
                return  seguimiento;
            }
        }
        return null;
    }

    public void terminarVisita(VisitaDTO visita, String idAnimal, boolean continuarVisitas){
        SeguimientoController.getInstancia().getSeguimientoByAnimal(idAnimal).getUltimaVisita().setEncuesta(visita.getEncuesta());
        SeguimientoController.getInstancia().getSeguimientoByAnimal(idAnimal).getUltimaVisita().setObservaciones(visita.getObservaciones());
        SeguimientoController.getInstancia().getSeguimientoByAnimal(idAnimal).setContinuarVisitas(continuarVisitas);
        if (continuarVisitas){
            SeguimientoController.getInstancia().getSeguimientoByAnimal(idAnimal).crearProximaVisita();
        }
    }
}