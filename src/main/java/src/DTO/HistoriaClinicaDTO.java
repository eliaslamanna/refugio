package src.DTO;

import src.Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoriaClinicaDTO {
    private Animal animal;

    private List<ControlPeriodicoDTO> controlesRealizados;
    private List<TratamientoMedicoDTO> tratamientosRealizados;
private SeguimientoDTO visitasADomicilio;
    private Date fechaDeCreacion;

    private Date ultimoCambio;

    public Animal getAnimal() {
        return animal;
    }

    public List<ControlPeriodicoDTO> getControlesRealizados() {
        return controlesRealizados;
    }

    public void setControlesRealizados(List<ControlPeriodicoDTO> controlesRealizados) {
        this.controlesRealizados = controlesRealizados;
    }

    public List<TratamientoMedicoDTO> getTratamientosRealizados() {
        return tratamientosRealizados;
    }

    public void setTratamientosRealizados(List<TratamientoMedicoDTO> tratamientosRealizados) {
        this.tratamientosRealizados = tratamientosRealizados;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Date getUltimoCambio() {
        return ultimoCambio;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setVisitasADomicilio(SeguimientoDTO visitasADomicilio) {
        this.visitasADomicilio = visitasADomicilio;
    }
    public SeguimientoDTO getVisitasADomicilio() {
        return visitasADomicilio;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setUltimoCambio(Date ultimoCambio) {
        this.ultimoCambio = ultimoCambio;
    }
    public boolean tieneSeguimientoActivo(){
        return this.visitasADomicilio != null;
    }
}
