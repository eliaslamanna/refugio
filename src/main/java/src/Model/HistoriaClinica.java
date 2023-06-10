package src.Model;

import src.Controller.AnimalController;
import src.DTO.AnimalDTO;
import src.DTO.HistoriaClinicaDTO;

import java.util.*;


public class HistoriaClinica {
    
    private Animal _animal;
    
    private List<Control> intervenciones;
    
    private Seguimiento visitasADomicilio;
    
    private Date fechaDeCreacion;
    
    private Date ultimoCambio;

    private EstrategiaExportacion estrategiaExportacion;

    public HistoriaClinica (Animal animal, Usuario veterinario){
        _animal = animal;

        //generar los controles para el animal y agregar el veterinario que controla

    }

    public void exportarFichaMedica(AnimalDTO animal) {
        for (Animal animal1:
                AnimalController.getInstancia().getAnimales()) {
            if (animal1.getId() == animal.getId()){
                estrategiaExportacion.exportar(this.toDTO());
            }
        }

    }

    public void setAnimal(Animal animal) {
        this._animal = animal;
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

    public Animal getAnimal() {
        return _animal;
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