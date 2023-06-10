package src.Controller;

import src.DTO.AlarmaDTO;
import src.DTO.AnimalDTO;
import src.DTO.SeguimientoMedicoDTO;
import src.DTO.UsuarioDTO;
import src.Model.*;

import java.util.*;


public class ClinicaController {

    private List<HistoriaClinica> historiales;

    private List<SeguimientoMedico> seguimientos;

    private List<Alarma> alarmas;
    private List<Usuario> veterinarios;
    private List<Usuario> visitadores;

    private static ClinicaController instancia;

    private ClinicaController() {
        this.historiales = new ArrayList<>();
        this.seguimientos = new ArrayList<>();
        this.alarmas = new ArrayList<>();
        this.veterinarios = new ArrayList<>();
        this.visitadores = new ArrayList<>();
    }

    public static ClinicaController getInstancia() {
        if (instancia == null) {
            instancia = new ClinicaController();
        }

        return instancia;
    }

    public void crearHistoriaClinica(AnimalDTO animal, UsuarioDTO veterinario) {
        this.crearHistoriaClinica(
                new Animal(animal.getNombre(), animal.getEdadAprox(), animal.getPeso(), animal.getAltura()
                , animal.getCondicionMedica(), animal.getTipoAnimal())
                ,new Usuario(veterinario.get_nombre(), veterinario.get_apellido(), veterinario.get_telefono()
                        , veterinario.get_email(), veterinario.get_dni(), veterinario.get_rol()))                ;

    }

    public void crearHistoriaClinica(Animal animal, Usuario veterinario) {

        HistoriaClinica historiaClinica = new HistoriaClinica(animal,veterinario);
        historiales.add(historiaClinica);

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