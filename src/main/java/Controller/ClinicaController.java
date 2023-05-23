package Controller;

import DTO.AlarmaDTO;
import DTO.AnimalDTO;
import DTO.SeguimientoMedicoDTO;
import Model.Alarma;
import Model.HistoriaClinica;
import Model.SeguimientoMedico;

import java.util.*;

/**
 * 
 */
public class ClinicaController {

    /**
     * Default constructor
     */
    public ClinicaController() {
    }

    /**
     * 
     */
    private List <HistoriaClinica> historiales;

    /**
     * 
     */
    private List<SeguimientoMedico> seguimientos;

    /**
     * 
     */
    private List<Alarma> alarmas;

    /**
     * @param animal 
     * @return
     */
    public HistoriaClinicaPdf exportarFichaMedicaPDF(AnimalDTO animal) {
        // TODO implement here
        return null;
    }

    /**
     * @param animal 
     * @return
     */
    public HistoriaClinicaExcel exportarFichaMedicaExcel(AnimalDTO animal) {
        // TODO implement here
        return null;
    }

    /**
     * @param seguimiento 
     * @param alarma 
     * @return
     */
    public void añadirAlarma(SeguimientoMedicoDTO seguimiento, AlarmaDTO alarma) {
        // TODO implement here
    }

    /**
     * @param seguimiento 
     * @return
     */
    public void nuevoSeguimientoMedico(SeguimientoMedicoDTO seguimiento) {
        // TODO implement here
    }

    /**
     * @param alarma 
     * @return
     */
    public void enviarAlarma(AlarmaDTO alarma) {
        // TODO implement here
    }

}