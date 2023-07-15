package src.Model;

import src.DTO.ControlPeriodicoDTO;
import src.Enum.Accion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControlPeriodico {
    private Animal _animal;
    private List<Accion> _acciones;
    private Usuario _atendidoPor;
    private LocalDateTime _horaDeAtencion;

    public ControlPeriodico (Animal animal, List<Accion> acciones, Usuario atendidoPor, LocalDateTime horaDeAtencion){
        _animal = animal;
        if (acciones == null)
            _acciones = new ArrayList<>();
        else
            _acciones = acciones;
        _atendidoPor = atendidoPor;
        _horaDeAtencion = horaDeAtencion;
    }
    public void agregarAccion(Accion accion){
        _acciones.add(accion);
    }
    public void setAnimal(Animal _animal) {
        this._animal = _animal;
    }
    public Animal getAnimal() {
        return _animal;
    }
    public void setAcciones(List<Accion> acciones) {
        this._acciones = acciones;
    }
    public List<Accion> getAcciones() {
        return _acciones;
    }
    public void setAtendidoPor(Usuario atendidoPor) {
        this._atendidoPor = atendidoPor;
    }
    public Usuario getAtentidoPor() {
        return _atendidoPor;
    }

    public LocalDateTime get_horaDeAtencion() {
        return _horaDeAtencion;
    }

    public void setHoraDeAtencion(LocalDateTime _horaDeAtencion) {
        this._horaDeAtencion = _horaDeAtencion;
    }

    public ControlPeriodicoDTO toDTO(){
        if (this._atendidoPor != null)
            return new ControlPeriodicoDTO(this._animal.toDTO(),this._acciones,this._atendidoPor.toDTO(),this._horaDeAtencion);
        else
            return new ControlPeriodicoDTO(this._animal.toDTO(),this._acciones,null,null);
    }

    public static ControlPeriodico toObject(ControlPeriodicoDTO controlPeriodicoDTO){
        return new ControlPeriodico(Animal.toObject(controlPeriodicoDTO.getAnimal()), controlPeriodicoDTO.getAcciones()
                ,controlPeriodicoDTO.getAtendidoPor() == null ? null : Usuario.toObject(controlPeriodicoDTO.getAtendidoPor())
                ,controlPeriodicoDTO.getHoraAtencion());
    }
}
