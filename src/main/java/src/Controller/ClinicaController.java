package src.Controller;

import src.DTO.*;

import src.DTO.UsuarioDTO;
import src.Model.Alarma;

import src.Model.Control;

import src.Model.Animal;

import src.Model.HistoriaClinica;
import src.Model.SeguimientoMedico;

import src.Model.*;

import java.util.ArrayList;
import java.util.List;


public class ClinicaController {

    private static List<HistoriaClinica> historiales;
    private static List<SeguimientoMedico> seguimientos;
    private static List<Alarma> alarmas;
    private static List<src.Model.Usuario> veterinarios;
    private static List<src.Model.Usuario> visitadores;
    private static List<Control> controles;
    private static ClinicaController instancia;

    private ClinicaController() {
        historiales = new ArrayList<>();
        seguimientos = new ArrayList<>();
        alarmas = new ArrayList<>();

        veterinarios = new ArrayList<>();
        visitadores = new ArrayList<>();
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
            if (animal.getId().equals(animal.getId())) {
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
        //return seguimientos.stream().filter(seguimiento -> seguimiento.getIdAnimal().equals(idAnimal)).findFirst().orElse(null);
        return historiales.stream().filter(historia -> historia.getAnimal().getId().equals(idAnimal)).findFirst().orElse(null);

    }

}