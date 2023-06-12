package src.Model;


import src.Controller.AdopcionesController;
import src.DTO.VisitaDTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Seguimiento {

    private int cadenciaVisita;

    private EstrategiaNotificacion medioNotificacion;

    private Boolean continuarVisitas;

    private int diasRecordatorio;

    private List<VisitaADomicilio> visitasADomicilio;

    private Usuario responsable;


    public Seguimiento(Usuario responsable, int cadenciaVisita, int diasRecordatorio, String estrategia) {
        this.cadenciaVisita = cadenciaVisita;
        if (estrategia.equals("SMS")){
            this.medioNotificacion = new NotificacionSMS();
        } else if (estrategia.equals("WHATSAPP")) {
            this.medioNotificacion = new NotificacionWhatApp();
        } else if (estrategia.equals("EMAIL")) {
            this.medioNotificacion = new NotificacionEmail();
        }
        this.continuarVisitas = true;
        this.diasRecordatorio = diasRecordatorio;
        this.visitasADomicilio = generarPrimeraVisita();
        this.responsable = responsable;
    }

    private VisitaADomicilio getVisitaMasReciente() {
        VisitaADomicilio visitaMasReciente = this.visitasADomicilio.get(0);
        for (int i = 1; i<  this.visitasADomicilio.size(); i++){
            VisitaADomicilio currentVisita = this.visitasADomicilio.get(i);
            Date currentDate  = currentVisita.getFechaVisita();

            if (currentDate.after(visitaMasReciente.getFechaVisita())){
                visitaMasReciente = currentVisita;
            }
        }
        return visitaMasReciente;
    }
    public void enviarRecordatorio(DatosNotificacion datos) {
        VisitaADomicilio visita = getVisitaMasReciente();
        LocalDate fechaActual = LocalDate.now();
        Date fechaVisita = visita.getFechaVisita();
        long diferenciaEnDias = ChronoUnit.DAYS.between(fechaActual, fechaVisita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        if (diferenciaEnDias <= this.diasRecordatorio){
            medioNotificacion.enviarNotificacion(datos);
        }
    }

    public void elegirMetodoNotificacion(EstrategiaNotificacion metodoPreferido) {
        this.medioNotificacion = metodoPreferido;
    }

    public void crearProximaVisita() {
        VisitaADomicilio newVisita = new VisitaADomicilio( getProximaFechaDeVisita(getVisitaMasReciente().getFechaVisita()),"", new Encuesta(EstadoLimpiezaAmbiente.MALO,EstadoLimpiezaAmbiente.MALO,EstadoLimpiezaAmbiente.MALO));
        this.visitasADomicilio.add(newVisita);
    }

    private Date getProximaFechaDeVisita(Date ultimaVisita){
        Calendar calendario = Calendar.getInstance();

        calendario.setTime(ultimaVisita);

        calendario.add(Calendar.DAY_OF_YEAR, this.cadenciaVisita);

        return calendario.getTime();
    }

    private List<VisitaADomicilio> generarPrimeraVisita(){
        Date fechaHoy = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<VisitaADomicilio> visitasLista = new ArrayList<>();
        VisitaADomicilio primeraVisita = new VisitaADomicilio(getProximaFechaDeVisita(fechaHoy),"",new Encuesta(EstadoLimpiezaAmbiente.MALO,EstadoLimpiezaAmbiente.MALO,EstadoLimpiezaAmbiente.MALO));
        visitasLista.add(primeraVisita);
        return visitasLista;
    }

    public DatosNotificacion getDatosAdoptante(String id_adoptante){
        // TODO Como encontrar los datos del adoptante?
        return null;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public int getCadenciaVisita() {
        return cadenciaVisita;
    }

    public EstrategiaNotificacion getMedioNotificacion() {
        return medioNotificacion;
    }

    public Boolean getContinuarVisitas() {
        return continuarVisitas;
    }

    public int getDiasRecordatorio() {
        return diasRecordatorio;
    }

    public List<VisitaADomicilio> getVisitasADomicilio() {
        return visitasADomicilio;
    }

    public VisitaADomicilio getUltimaVisita(){
        VisitaADomicilio ultimaVisita = visitasADomicilio.get(visitasADomicilio.size()-1);
        return ultimaVisita;
    }


    public void setCadenciaVisita(int cadenciaVisita) {
        this.cadenciaVisita = cadenciaVisita;
    }

    public void setMedioNotificacion(EstrategiaNotificacion medioNotificacion) {
        this.medioNotificacion = medioNotificacion;
    }

    public void setContinuarVisitas(Boolean continuarVisitas) {
        this.continuarVisitas = continuarVisitas;
    }

    public void setDiasRecordatorio(int diasRecordatorio) {
        this.diasRecordatorio = diasRecordatorio;
    }

    public void setVisitasADomicilio(List<VisitaADomicilio> visitasADomicilio) {
        this.visitasADomicilio = visitasADomicilio;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }
}