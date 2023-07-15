package src.DTO;

import src.Enum.Accion;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TratamientoMedicoDTO extends ControlPeriodicoDTO {
    private boolean _enTratamiento = false;
    private LocalDateTime _inicioTratamiento;
    private LocalDateTime _finTratamiento;

    public TratamientoMedicoDTO(AnimalDTO animal, List<Accion> acciones, UsuarioDTO atendidoPor, boolean enTratamiento
            , LocalDateTime inicioTratamiento, LocalDateTime finTratamiento, LocalDateTime horaDeAtencion) {
        super(animal, acciones, atendidoPor, horaDeAtencion);
        this._enTratamiento = enTratamiento;
        this._inicioTratamiento = inicioTratamiento;
        this._finTratamiento = finTratamiento;
    }


    public boolean isEnTratamiento() {
        return _enTratamiento;
    }

    public void setEnTratamiento(boolean enTratamiento) {
        this._enTratamiento = enTratamiento;
    }

    public LocalDateTime getInicioTratamiento() {
        return _inicioTratamiento;
    }

    public void setInicioTratamiento(LocalDateTime inicioTratamiento) {
        this._inicioTratamiento = inicioTratamiento;
    }

    public LocalDateTime getFinTratamiento() {
        return _finTratamiento;
    }

    public void setFinTratamiento(LocalDateTime finTratamiento) {
        this._finTratamiento = finTratamiento;
    }

    public void finalizarTratamiento(){
        _finTratamiento = LocalDateTime.now();
        _enTratamiento = false;
    }

    public void finalizarTratamiento(LocalDateTime finTratamiento){
        _finTratamiento = finTratamiento;
        _enTratamiento = false;
    }

}
