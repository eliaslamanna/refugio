package src.Controller;

import src.DTO.AlarmaDTO;
import src.Model.*;

import java.util.ArrayList;
import java.util.List;

public class AlarmaController {
    private static AlarmaController instancia;
    private List<Alarma> alarmas;

    private AlarmaController(){
        this.alarmas = new ArrayList<>();
    }

    public static AlarmaController getInstancia() {
        if (instancia == null)
            instancia = new AlarmaController();
        return instancia;
    }

    /*
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

     */

    public void crearAlarma(AlarmaDTO alarmaDTO){
        alarmas.add(Alarma.toObject(alarmaDTO));
    }

    /*
    public SeguimientoMedico buscarSeguimientoMedico(String id){

        return null; //seguimientos.stream().filter(seguimiento -> seguimiento.getIdSeguimiento().equals(id)).findFirst().orElse(null);

    }
    public Control buscarControl(String id){
        return null; //controles.stream().filter(control -> control.getIdControl().equals(id)).findFirst().orElse(null);
    }
    */

    // ----------------------------------------------- COMIENZO TRATADO DE ALARMAS ----------------------------------------------------
    public int contarAlarmasAtendibles(){
        int cantAlarmasAtendibles = 0;

        for (Alarma alarma : alarmas){
            if (alarma.isAtendible())
                cantAlarmasAtendibles++;
        }
        return cantAlarmasAtendibles;
    }

    public List<AlarmaDTO> getAlarmasAtendibles(){
        List<AlarmaDTO> alarmarAtendibles = new ArrayList<>();

        for (Alarma alarma : alarmas){
            if (alarma.isAtendible())
                alarmarAtendibles.add(alarma.toDTO());
        }
        return alarmarAtendibles;
    }

    public void atenderAlarma(AlarmaDTO alarmaDTO){

    }
    /*
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
        return null; //seguimientos.stream().filter(seguimiento -> seguimiento.getIdAnimal().equals(idAnimal)).findFirst().orElse(null);
    }

    public List<AlarmaXControlDTO> generarListaAlarmaConControl(List<Alarma> alarmas){
        List <AlarmaXControlDTO> alarmasXControl = new ArrayList<>();
        for (int i = 0; i < alarmas.size(); i++){
            AlarmaXControlDTO alarmaNueva = new AlarmaXControlDTO(alarmas.get(i).getIdAlarma(),alarmas.get(i).getFechaInicial(),alarmas.get(i).getAccionesDeControl());
            alarmasXControl.add(alarmaNueva);
        }

        return alarmasXControl;
    }
    */

 /*
    public void atenderAlarma(String idAlarma, String idAnimal) {
        SeguimientoMedico seguimiento = buscarSeguimientoXIdAnimal(idAnimal);
        Alarma alarmaCancelada = buscarAlarma(idAlarma);

        ControlRealizado controlRealizado = new ControlRealizado(alarmaCancelada.getControl());
        HistoriaClinica historiaClinica = ClinicaController.getInstancia().buscarHistoriaClinicaXAnimal(idAnimal);
        historiaClinica.registrarControlPeriodico(controlRealizado);

        Alarma alarmaNueva = new Alarma(alarmaCancelada.getPeriodicidad(), alarmaCancelada.getControl());
        seguimiento.removarAlarma(alarmaCancelada.getIdAlarma());
        seguimiento.agregarAlarma(alarmaNueva);
    }
 */
    // ----------------------------------------------- FIN TRATADO DE ALARMAS ----------------------------------------------------

    private Alarma buscarAlarma(String id){

        //return seguimientos.stream().filter(seguimiento -> seguimiento.getIdSeguimiento().equals(id)).findFirst().orElse(null);
        return alarmas.stream().filter(alarma -> alarma.getIdAlarma().equals(id)).findFirst().orElse(null);

    }

    public void enviarAlarma(AlarmaDTO alarma) {
        // TODO implement here
    }

}
