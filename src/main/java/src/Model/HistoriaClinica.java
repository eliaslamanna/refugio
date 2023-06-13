package src.Model;

import src.Controller.AnimalController;
import src.DTO.AnimalDTO;
import src.DTO.HistoriaClinicaDTO;

import java.util.*;


public class HistoriaClinica {
    
    private Animal _animal;
    
    private List<ControlRealizado> intervenciones;
    
    private Seguimiento visitasADomicilio;
    
    private Date fechaDeCreacion;
    
    private Date ultimoCambio;

    private EstrategiaExportacion estrategiaExportacion;

    public HistoriaClinica (Animal animal, Usuario veterinario){
        _animal = animal;
        intervenciones = new ArrayList<>();
        fechaDeCreacion = new Date();
        ultimoCambio = new Date();
        //generar los controles para el animal y agregar el veterinario que controla
    }

    public void exportarFichaMedica() {
                estrategiaExportacion.exportar(this.toDTO());
    }

    public void setAnimal(Animal animal) {
        this._animal = animal;
    }

    public void setIntervenciones(List<ControlRealizado> intervenciones) {
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

    public Animal getAnimal() {
        return _animal;
    }

    public List<ControlRealizado> getIntervenciones() {
        return intervenciones;
    }

    public void agregarIntervencion(ControlRealizado control){
        intervenciones.add(control);
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

    public void setEstrategiaExportacion(EstrategiaExportacion estrategiaExportacion) {
        this.estrategiaExportacion = estrategiaExportacion;
    }

    private HistoriaClinicaDTO toDTO(){
        HistoriaClinicaDTO historia = new HistoriaClinicaDTO();
        historia.setAnimal(this._animal);
        historia.setIntervenciones(this.intervenciones);
        historia.setFechaDeCreacion(this.fechaDeCreacion);
        historia.setVisitasADomicilio(this.visitasADomicilio);
        historia.setUltimoCambio(this.ultimoCambio);
        return historia;
    }
}