package src.DTO;

import src.Model.Animal;
import src.Model.Control;
import src.Model.Seguimiento;

import java.util.Date;
import java.util.List;

public class HistoriaClinicaDTO {
    private Animal animal;

    private List<Control> intervenciones;

    private Seguimiento visitasADomicilio;

    private Date fechaDeCreacion;

    private Date ultimoCambio;

    public Animal getAnimal() {
        return animal;
    }

    public List<Control> getIntervenciones() {
        return intervenciones;
    }

    public Seguimiento getVisitasADomicilio() {
        return visitasADomicilio;
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

    public void setIntervenciones(List<Control> intervenciones) {
        this.intervenciones = intervenciones;
    }

    public void setVisitasADomicilio(Seguimiento visitasADomicilio) {
        this.visitasADomicilio = visitasADomicilio;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setUltimoCambio(Date ultimoCambio) {
        this.ultimoCambio = ultimoCambio;
    }
}
