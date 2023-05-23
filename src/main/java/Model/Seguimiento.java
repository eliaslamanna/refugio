package Model;

import Model.DatosNotificacion;

/**
 * 
 */
public class Seguimiento {

    /**
     * Default constructor
     */
    public Seguimiento() {
    }

    /**
     * 
     */
    private Visitador Responsable;

    /**
     * 
     */
    private int cadenciaVisita;

    /**
     * 
     */
    private EstrategiaNotificacion medioNotificacion;

    /**
     * 
     */
    private Boolean continuarVisitas;

    /**
     * 
     */
    private int diasRecordatorio;

    /**
     * @param datos 
     * @return
     */
    public void enviarRecordatorio(DatosNotificacion datos) {
        // TODO implement here
    }

    /**
     * @param metodoPreferido 
     * @param diasRecordatorio 
     * @return
     */
    public void cambiarMetodoNotificacion(EstrategiaNotificacion metodoPreferido, int diasRecordatorio) {
        // TODO implement here
    }

}