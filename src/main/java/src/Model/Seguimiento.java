package src.Model;


import java.util.ArrayList;
import java.util.List;

public class Seguimiento {

    private Visitador Responsable;

    private int cadenciaVisita;

    private EstrategiaNotificacion medioNotificacion;

    private Boolean continuarVisitas;

    private int diasRecordatorio;

    private List<VisitaADomicilio> visitasADomicilio = new ArrayList<>();

    private Visitador responsable;

    private Adopcion adopcion;

    public void enviarRecordatorio(DatosNotificacion datos) {
        medioNotificacion.enviarNotificacion(datos);
    }

    // TODO mover diasRecordatorio
    public void cambiarMetodoNotificacion(EstrategiaNotificacion metodoPreferido, int diasRecordatorio) {
        this.medioNotificacion = metodoPreferido;
    }

}