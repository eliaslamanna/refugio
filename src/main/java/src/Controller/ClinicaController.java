package src.Controller;

import src.DTO.*;

import src.DTO.UsuarioDTO;
import src.Enum.Accion;
import src.Model.Alarma;

import src.Model.Animal;

import src.Model.HistoriaClinica;

import src.Model.*;

import java.util.ArrayList;
import java.util.List;


public class ClinicaController {

    private static List<HistoriaClinica> historiales;
    private List<Accion>  accionesDeTratamientoMedico;
    private List<Accion> accionesDeControlDeSalud;
    private static ClinicaController instancia;

    private ClinicaController() {
        historiales = new ArrayList<>();
        
        accionesDeControlDeSalud = new ArrayList<>();
        accionesDeControlDeSalud.add(Accion.CONTROLAR_PARASITOS);
        accionesDeControlDeSalud.add(Accion.CONTROLAR_PESO);
        accionesDeControlDeSalud.add(Accion.CONTROLAR_NUTRICION);
        accionesDeControlDeSalud.add(Accion.CONTROLAR_TAMANIO);

        accionesDeTratamientoMedico = new ArrayList<>();
        accionesDeTratamientoMedico.add(Accion.COLOCAR_ANTIPARASITARIO);
        accionesDeTratamientoMedico.add(Accion.COLOCAR_VACUNA);
    }

    public static ClinicaController getInstancia() {
        if (instancia == null) {
            instancia = new ClinicaController();
        }

        return instancia;
    }

    public void crearHistoriaClinica(AnimalDTO animal, UsuarioDTO veterinario) {

        HistoriaClinica historiaClinica = new HistoriaClinica(Animal.toObject(animal), src.Model.Usuario.toObject(veterinario));
        historiales.add(historiaClinica);

    }

    public void exportarFichaMedica(AnimalDTO animal, String metodo) {
        for (HistoriaClinica historia : historiales) {
            if (historia.getAnimal().getId().equals(animal.getId())) {
                if (metodo.equals("PDF")) {
                    historia.setEstrategiaExportacion(new ExportarPDF());
                } else if (metodo.equals("EXCEL")) {
                    historia.setEstrategiaExportacion(new ExportarExcell());
                } else {
                    System.out.println("ERROR INTERNO");
                }
                historia.exportarFichaMedica();
            }
        }
    }

    public HistoriaClinica buscarHistoriaClinicaXAnimal(String idAnimal){
        return historiales.stream().filter(historia -> historia.getAnimal().getId().equals(idAnimal)).findFirst().orElse(null);
    }

    public List<Accion> getAccionesDeControlDeSalud() {
        List<Accion> acciones = new ArrayList<>();

        for (Accion accion: accionesDeControlDeSalud){
            acciones.add(accion);
        }
        return acciones;
    }

    public List<Accion> getAccionesDeTratamientoMedico() {
        List<Accion> acciones = new ArrayList<>();

        for (Accion accion: accionesDeTratamientoMedico){
            acciones.add(accion);
        }
        return acciones;
    }

    public void registrarAtencion(TratamientoMedico control) {
        HistoriaClinica historiaClinica = buscarHistoriaClinicaXAnimal(control.getAnimal().getId());
        historiaClinica.registrarControlPeriodico(control);
    }

    public void registrarAtencion(ControlPeriodico control){
        HistoriaClinica historiaClinica = buscarHistoriaClinicaXAnimal(control.getAnimal().getId());
        historiaClinica.registrarControlPeriodico(control);
    }
}