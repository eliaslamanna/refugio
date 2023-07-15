package src.DTO;

import src.Enum.Accion;

import java.time.LocalDateTime;
import java.util.List;

public class ControlPeriodicoDTO {
    private AnimalDTO _animal;
    private List<Accion> _acciones;
    private UsuarioDTO _atendidoPor;
    private LocalDateTime _horaAtencion;

    public ControlPeriodicoDTO(AnimalDTO _animal, List<Accion> _acciones, UsuarioDTO _atendidoPor, LocalDateTime horaAtencion) {
        this._animal = _animal;
        this._acciones = _acciones;
        this._atendidoPor = _atendidoPor;
        this._horaAtencion = horaAtencion;
    }

    public AnimalDTO getAnimal() {
        return _animal;
    }

    public void setAnimal(AnimalDTO animal) {
        this._animal = _animal;
    }

    public List<Accion> getAcciones() {
        return _acciones;
    }

    public void setAcciones(List<Accion> acciones) {
        this._acciones = acciones;
    }

    public UsuarioDTO getAtendidoPor() {
        return _atendidoPor;
    }

    public void setAtendidoPor(UsuarioDTO atendidoPor) {
        this._atendidoPor = atendidoPor;
    }

    public LocalDateTime getHoraAtencion() {
        return _horaAtencion;
    }

    public void setHoraAtencion(LocalDateTime _horaAtencion) {
        this._horaAtencion = _horaAtencion;
    }
}
