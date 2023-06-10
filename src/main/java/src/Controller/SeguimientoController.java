package src.Controller;

import src.Model.DatosNotificacion;
import src.Model.Seguimiento;

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

}