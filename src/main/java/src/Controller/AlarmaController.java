package src.Controller;

import src.DTO.AlarmaDTO;
import src.DTO.TratamientoMedicoDTO;
import src.DTO.UsuarioDTO;
import src.Model.*;

import java.time.LocalDateTime;
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

    public void atenderAlarma(AlarmaDTO alarmaDTO, UsuarioDTO atendidoPor){

        Alarma alarmaAAtender = null;
        Usuario veterinario = Usuario.toObject(atendidoPor);

        for(Alarma alarma : alarmas){
            if (alarma.getIdAlarma().equals(alarmaDTO.getIdAlarma())) {
                alarmaAAtender = alarma;
                if (alarmaDTO.isTratamientoMedico()) {
                    alarmaAAtender.setControl(TratamientoMedico.toObject(alarmaDTO.getTratamientoMedico()));
                }
                else {
                    alarmaAAtender.setControl(ControlPeriodico.toObject(alarmaDTO.getControlDeSalud()));
                }
                alarmaAAtender.getControl().setAtendidoPor(veterinario);
                alarmaAAtender.getControl().setHoraDeAtencion(LocalDateTime.now());
            }
        }

        if (alarmaAAtender != null && alarmaAAtender.isAtendible()){
            alarmaAAtender.atenderAlarma(veterinario);
            if (alarmaDTO.isTratamientoMedico()) {
                ClinicaController.getInstancia().registrarAtencion((TratamientoMedico) alarmaAAtender.getControl());
                if (alarmaDTO.getTratamientoMedico().isEnTratamiento())
                    alarmas.add(new Alarma(alarmaDTO.getPeriodicidad(), alarmaAAtender.obtenerProximaFecha()
                            , new TratamientoMedico(
                            Animal.toObject(alarmaDTO.getTratamientoMedico().getAnimal())
                            , alarmaDTO.getTratamientoMedico().getAcciones()
                            , null
                            , alarmaDTO.getTratamientoMedico().getInicioTratamiento()
                            , null)));
            }
            else {
                ClinicaController.getInstancia().registrarAtencion(alarmaAAtender.getControl());
                alarmas.add(new Alarma(alarmaDTO.getPeriodicidad(), alarmaAAtender.obtenerProximaFecha()
                        , new ControlPeriodico(Animal.toObject(alarmaDTO.getControlDeSalud().getAnimal())
                        , alarmaDTO.getControlDeSalud().getAcciones()
                        , null
                        , null)));
            }
        }
    }

}
