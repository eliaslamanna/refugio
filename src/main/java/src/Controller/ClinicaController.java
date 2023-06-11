package src.Controller;

import src.DTO.AlarmaDTO;
import src.DTO.AnimalDTO;
import src.DTO.SeguimientoMedicoDTO;

import src.Model.Alarma;

import src.Model.Control;

import src.Model.Animal;

import src.Model.HistoriaClinica;
import src.Model.SeguimientoMedico;

import src.DTO.UsuarioDTO;
import src.Model.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ClinicaController {

    private List<HistoriaClinica> historiales;

    private List<SeguimientoMedico> seguimientos;

    private List<Alarma> alarmas;
    private List<Usuario> veterinarios;
    private List<Usuario> visitadores;

    private List<Alarma> alarmasActivas;

    private List<Control> controles;

    private static ClinicaController instancia;

    private ClinicaController() {
        this.historiales = new ArrayList<>();
        this.seguimientos = new ArrayList<>();
        this.alarmas = new ArrayList<>();
        this.alarmasActivas = new ArrayList<>();
        this.veterinarios = new ArrayList<>();
        this.visitadores = new ArrayList<>();

    }

    public static ClinicaController getInstancia() {
        if (instancia == null) {
            instancia = new ClinicaController();
        }

        return instancia;
    }


    public void crearHistoriaClinica(Animal animal, Usuario veterinario) {

        HistoriaClinica historiaClinica = new HistoriaClinica(animal,veterinario);
        historiales.add(historiaClinica);

    }



    public HistoriaClinica exportarFichaMedica(AnimalDTO animal) {
        for (HistoriaClinica historia :
                this.historiales) {
            for (Animal animal1 : AnimalController.getInstancia().getAnimales()) {
                if (animal.getId() == animal1.getId()) {
                    historia.exportarFichaMedica(animal);
                }
            }
        }
        return null;
    }

    public void agregarAlarma (String idSeguimiento, AlarmaDTO alarma) {

        // Se valida si existe el seguimiento y el control para añadir la alarma
        Control control = buscarControl(alarma.getControl());
        SeguimientoMedico seguimiento = buscarSeguimientoMedico(idSeguimiento);
        if(seguimiento != null ){
            if(control != null) {
                Alarma alarmaNueva = new Alarma(alarma.getPeriodicidad(), control);
                alarmas.add(alarmaNueva);
                seguimiento.agregarAlarma(alarmaNueva);
            }
            else {
                System.out.println("\n No se encontró el Control ingresado \n No se dió de alta la nueva alarma \n");
            }
        }
        else {
            System.out.println("\n No se encontró el Seguimiento Medico ingresado \n No se dió de alta la nueva alarma \n");
        }

    }

    public SeguimientoMedico buscarSeguimientoMedico(String id){

        return seguimientos.stream().filter(seguimiento -> seguimiento.getIdSeguimiento().equals(id)).findFirst().orElse(null);

    }

    public Control buscarControl(String id){
        return controles.stream().filter(control -> control.getIdControl().equals(id)).findFirst().orElse(null);
    }

    public void buscarAlarmasActivas(){
        alarmasActivas.clear();
        LocalDateTime fechaActual = LocalDateTime.now();
        for (int i = 0; i < alarmas.size(); i ++){
            if(alarmas.get(i).getPeriodicidad().isBefore(fechaActual)){
                alarmasActivas.add(alarmas.get(i));
            }
        }
    }



    public void nuevoSeguimientoMedico(SeguimientoMedicoDTO seguimiento) {
        // TODO implement here
    }


    public void enviarAlarma(AlarmaDTO alarma) {
        // TODO implement here
    }


}