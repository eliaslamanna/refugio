package src.Controller;

import src.DTO.*;

import src.DTO.UsuarioDTO;
import src.Model.Alarma;

import src.Model.Control;

import src.Model.Animal;

import src.Model.HistoriaClinica;
import src.Model.SeguimientoMedico;

import src.Model.*;

import src.Enum.Accion;

import java.util.ArrayList;
import java.util.List;


public class ClinicaController {

    private List<HistoriaClinica> historiales;

    private List<SeguimientoMedico> seguimientos;

    private List<Alarma> alarmas;
    private List<src.Model.Usuario> veterinarios;
    private List<src.Model.Usuario> visitadores;

    private List<Control> controles;

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

        HistoriaClinica historiaClinica = new HistoriaClinica(Animal.toObject(animal), src.Model.Usuario.toObject(veterinario));
        historiales.add(historiaClinica);

    }
    public List<Control> getControles(){
        return controles;
    }

    public void exportarFichaMedica(AnimalDTO animal, String metodo) {
        for (HistoriaClinica historia :
                this.historiales) {
            for (Animal animal1 : AnimalController.getInstancia().getAnimales()) {
                if (animal.getId().equals(animal1.getId())) {
                    if (metodo.equals("PDF")){
                        historia.setEstrategiaExportacion(new ExportarPDF());
                    } else if (metodo.equals("EXCEL")) {
                        historia.setEstrategiaExportacion(new ExportarExcell());
                    }
                    else {
                        System.out.println("ERROR INTERNO");
                    }
                    historia.exportarFichaMedica();
                }
            }
        }
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


    // ----------------------------------------------- COMIENZO TRATADO DE ALARMAS ----------------------------------------------------

    public int hayAlarmasActivas(){
        int cantAlarmasActivas = 0;
        int aux;
        for (int i = 0; i < seguimientos.size(); i ++){
            aux = seguimientos.get(i).buscarAlarmasActivas();
            if(aux != 0){
                cantAlarmasActivas = cantAlarmasActivas + aux;
            }
        }
        return cantAlarmasActivas;
    }

    public List<AnimalXAlarmaDTO> traerSeguimientosConAlarmasActivas(){
        List <SeguimientoMedico> seguimientosConAlarmas = new ArrayList<>();
        for (int i = 0; i < seguimientos.size(); i ++){
            if(seguimientos.get(i).buscarAlarmasActivas() !=0){
                seguimientosConAlarmas.add(seguimientos.get(i));
            }
        }

        return generarListaAnimalConAlarmas(seguimientosConAlarmas);

    }


    public List<AnimalXAlarmaDTO> generarListaAnimalConAlarmas(List<SeguimientoMedico> seguimientos){

        List <AnimalXAlarmaDTO> animalesConAlarmas = new ArrayList<>();
        for (int i = 0; i < seguimientos.size(); i ++){
            AnimalXAlarmaDTO animalNuevo = new AnimalXAlarmaDTO(seguimientos.get(i).getAnimal().getId(), seguimientos.get(i).getAnimal().getNombre(), seguimientos.get(i).getCantidadAlarmasActivas());
            animalesConAlarmas.add(animalNuevo);
        }
        return animalesConAlarmas;

    }



    public List<AlarmaXControlDTO> traerAlarmasActivasDeSeguimiento(String idAnimal){

        SeguimientoMedico seguimiento = buscarSeguimientoXIdAnimal(idAnimal);
        List<Alarma> alarmasActivas = seguimiento.getAlarmasActivas();

        return generarListaAlarmaConControl(alarmasActivas);



    }

    public SeguimientoMedico buscarSeguimientoXIdAnimal(String idAnimal){
        return seguimientos.stream().filter(seguimiento -> seguimiento.getIdAnimal().equals(idAnimal)).findFirst().orElse(null);
    }


    public List<AlarmaXControlDTO> generarListaAlarmaConControl(List<Alarma> alarmas){
        List <AlarmaXControlDTO> alarmasXControl = new ArrayList<>();
        for (int i = 0; i < alarmas.size(); i++){
            AlarmaXControlDTO alarmaNueva = new AlarmaXControlDTO(alarmas.get(i).getIdAlarma(),alarmas.get(i).getFechaLimite(),alarmas.get(i).getAccionesDeControl());
            alarmasXControl.add(alarmaNueva);
        }

        return alarmasXControl;
    }



    public void cancelarAlarma(String idAlarma, String idAnimal) {
        SeguimientoMedico seguimiento = buscarSeguimientoXIdAnimal(idAnimal);
        Alarma alarmaCancelada = buscarAlarma(idAlarma);

        ControlRealizado controlRealizado = new ControlRealizado(alarmaCancelada.getControl());
        HistoriaClinica historiaClinica = buscarHistoriaClinicaXAnimal(idAnimal);
        historiaClinica.agregarIntervencion(controlRealizado);

        Alarma alarmaNueva = new Alarma(alarmaCancelada.getPeriodicidad(), alarmaCancelada.getControl());
        seguimiento.removarAlarma(alarmaCancelada.getIdAlarma());
        seguimiento.agregarAlarma(alarmaNueva);


    }




    // ----------------------------------------------- FIN TRATADO DE ALARMAS ----------------------------------------------------


    public HistoriaClinica buscarHistoriaClinicaXAnimal(String idAnimal){
        //return seguimientos.stream().filter(seguimiento -> seguimiento.getIdAnimal().equals(idAnimal)).findFirst().orElse(null);
        return historiales.stream().filter(historia -> historia.getAnimal().getId().equals(idAnimal)).findFirst().orElse(null);


    }

    public Alarma buscarAlarma(String id){

        //return seguimientos.stream().filter(seguimiento -> seguimiento.getIdSeguimiento().equals(id)).findFirst().orElse(null);
        return alarmas.stream().filter(alarma -> alarma.getIdAlarma().equals(id)).findFirst().orElse(null);

    }


    public void nuevoSeguimientoMedico(SeguimientoMedicoDTO seguimiento) {
        // TODO implement here
    }


    public void enviarAlarma(AlarmaDTO alarma) {
        // TODO implement here
    }


}