package src.Model;

import src.DTO.HistoriaClinicaDTO;

import java.util.*;


public class HistoriaClinica {
    
    private Animal _animal;
    
    private List<ControlPeriodico> controlesRealizados;
    private List<TratamientoMedico> tratamientosRealizados;

    private Seguimiento visitasADomicilio;
    
    private Date fechaDeCreacion;
    
    private Date ultimoCambio;

    private EstrategiaExportacion estrategiaExportacion;

    public HistoriaClinica (Animal animal, Usuario veterinario){
        _animal = animal;
        controlesRealizados = new ArrayList<>();
        tratamientosRealizados = new ArrayList<>();
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

    public void setControlesRealizados(List<ControlPeriodico> controlesRealizados) {
        this.controlesRealizados = controlesRealizados;
    }

    public void setTratamientosRealizados(List<TratamientoMedico> tratamientosRealizados) {
        this.tratamientosRealizados = tratamientosRealizados;
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

    public List<ControlPeriodico> getControlesRealizados() {
        return this.controlesRealizados;
    }

    public List<TratamientoMedico> getTratamientosRealizados() {
        return this.tratamientosRealizados;
    }

    public void registrarControlPeriodico(ControlPeriodico control){
        controlesRealizados.add(control);
    }

    public void registrarControlPeriodico(TratamientoMedico control){
        tratamientosRealizados.add(control);
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
        //historia.setIntervenciones(this.controlesRealizados);
        historia.setFechaDeCreacion(this.fechaDeCreacion);
        historia.setVisitasADomicilio(this.visitasADomicilio);
        historia.setUltimoCambio(this.ultimoCambio);
        return historia;
    }
}