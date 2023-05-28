package src.Controller;

import src.DTO.AlarmaDTO;
import src.DTO.AnimalDTO;
import src.DTO.SeguimientoMedicoDTO;
import src.Model.Alarma;
import src.Model.HistoriaClinica;
import src.Model.SeguimientoMedico;

import java.util.*;


public class ClinicaController {

    private List <HistoriaClinica> historiales;

    private List<SeguimientoMedico> seguimientos;

    private List<Alarma> alarmas;

    private static ClinicaController instancia;

    private ClinicaController() {
        this.historiales = new ArrayList<>();
        this.seguimientos = new ArrayList<>();
        this.alarmas = new ArrayList<>();
    }

    public static ClinicaController getInstancia() {
        if(instancia == null) {
            instancia = new ClinicaController();
        }

        return instancia;
    }

    public HistoriaClinicaPdf exportarFichaMedicaPDF(AnimalDTO animal) {
        // TODO implement here
        return null;
    }

    
    public HistoriaClinicaExcel exportarFichaMedicaExcel(AnimalDTO animal) {
        // TODO implement here
        return null;
    }

    public void añadirAlarma(SeguimientoMedicoDTO seguimiento, AlarmaDTO alarma) {
        // TODO implement here
    }

    public void nuevoSeguimientoMedico(SeguimientoMedicoDTO seguimiento) {
        // TODO implement here
    }

    
    public void enviarAlarma(AlarmaDTO alarma) {
        // TODO implement here
    }

}