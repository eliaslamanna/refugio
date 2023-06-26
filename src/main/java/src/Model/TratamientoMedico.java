package src.Model;

import src.DTO.TratamientoMedicoDTO;
import src.Enum.Accion;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TratamientoMedico extends ControlPeriodico {
    private boolean _enTratamiento = false;
    private LocalDateTime _inicioTratamiento;
    private LocalDateTime _finTratamiento;

    public TratamientoMedico(Animal animal, List<Accion> acciones, Usuario atendidoPor, LocalDateTime inicioTratamiento
            , LocalDateTime finTratamiento, boolean enTratamiento) {
        super(animal, acciones, atendidoPor);
        this._enTratamiento = enTratamiento;
        this._inicioTratamiento = inicioTratamiento;
        this._finTratamiento = finTratamiento;
    }

    public TratamientoMedico(Animal animal, List<Accion> acciones, Usuario atendidoPor, LocalDateTime inicioTratamiento) {
        this(animal, acciones, atendidoPor, inicioTratamiento, null, true);
    }

    public void finalizarTratamiento(LocalDateTime finTratamiento) {
        this._finTratamiento = finTratamiento;
        this._enTratamiento = false;
    }

    public void finalizarTratamiento(){
        this.finalizarTratamiento(LocalDateTime.now());
    }

    public TratamientoMedicoDTO toDTO(){
        return new TratamientoMedicoDTO(this.getAnimal().toDTO(), this.getAcciones(), this.getAtentidoPor().toDTO()
                ,this._enTratamiento, _inicioTratamiento, _finTratamiento);
    }

    public static TratamientoMedico toObject(TratamientoMedicoDTO tratamientoMedicoDTO){
        return new TratamientoMedico(Animal.toObject(tratamientoMedicoDTO.getAnimal()), tratamientoMedicoDTO.getAcciones()
                ,Usuario.toObject(tratamientoMedicoDTO.getAtendidoPor()), tratamientoMedicoDTO.getInicioTratamiento()
                ,tratamientoMedicoDTO.getFinTratamiento(), tratamientoMedicoDTO.isEnTratamiento());
    }
}
