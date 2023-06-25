package src.Model;


import src.DTO.DatosNotificacion;
import src.DTO.SeguimientoDTO;
import src.DTO.VisitaDTO;
import src.Enum.EstadoLimpiezaAmbiente;
import src.Enum.MedioRecordatorio;

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


    public Seguimiento(Usuario responsable, int cadenciaVisita, int diasRecordatorio, MedioRecordatorio estrategia) {
        this.cadenciaVisita = cadenciaVisita;
        if (estrategia.equals(MedioRecordatorio.SMS)) {
            this.medioNotificacion = new NotificacionSMS();
        } else if (estrategia.equals(MedioRecordatorio.WHATSAPP)) {
            this.medioNotificacion = new NotificacionWhatsApp();
        } else if (estrategia.equals(MedioRecordatorio.EMAIL)) {
            this.medioNotificacion = new NotificacionEmail();
        }
        this.continuarVisitas = true;
        this.diasRecordatorio = diasRecordatorio;
        this.visitasADomicilio = generarPrimeraVisita();
        this.responsable = responsable;
    }

    public static Seguimiento toObject(SeguimientoDTO seguimientoDTO) {
        return new Seguimiento(
                Usuario.toObject(seguimientoDTO.getResponsable())
                , seguimientoDTO.getCadenciaVisita()
                , seguimientoDTO.getDiasRecordatorio()
                , seguimientoDTO.getMedioNotificacion());
    }

    private VisitaADomicilio getVisitaMasReciente() {
        VisitaADomicilio visitaMasReciente = this.visitasADomicilio.get(0);
        for (int i = 1; i < this.visitasADomicilio.size(); i++) {
            VisitaADomicilio currentVisita = this.visitasADomicilio.get(i);
            Date currentDate = currentVisita.getFechaVisita();

            if (currentDate.after(visitaMasReciente.getFechaVisita())) {
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
        if (diferenciaEnDias <= this.diasRecordatorio) {
            medioNotificacion.enviarNotificacion(datos);
        }
    }

    public void elegirMetodoNotificacion(EstrategiaNotificacion metodoPreferido) {
        this.medioNotificacion = metodoPreferido;
    }

    public void crearProximaVisita() {
        VisitaADomicilio newVisita = new VisitaADomicilio(getProximaFechaDeVisita(getVisitaMasReciente().getFechaVisita()), "", new Encuesta(EstadoLimpiezaAmbiente.MALO, EstadoLimpiezaAmbiente.MALO, EstadoLimpiezaAmbiente.MALO));
        this.visitasADomicilio.add(newVisita);
    }

    private Date getProximaFechaDeVisita(Date ultimaVisita) {
        Calendar calendario = Calendar.getInstance();

        calendario.setTime(ultimaVisita);

        calendario.add(Calendar.DAY_OF_YEAR, this.cadenciaVisita);

        return calendario.getTime();
    }

    private List<VisitaADomicilio> generarPrimeraVisita() {
        Date fechaHoy = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<VisitaADomicilio> visitasLista = new ArrayList<>();
        VisitaADomicilio primeraVisita = new VisitaADomicilio(getProximaFechaDeVisita(fechaHoy), "", new Encuesta(EstadoLimpiezaAmbiente.MALO, EstadoLimpiezaAmbiente.MALO, EstadoLimpiezaAmbiente.MALO));
        visitasLista.add(primeraVisita);
        return visitasLista;
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

    public List<VisitaADomicilio> getVisitasADomicilioTerminadas() {
        List<VisitaADomicilio> visitasTerminadas =  new ArrayList<>();

        for (VisitaADomicilio visitaADomicilio : visitasADomicilio) {
            if (visitaADomicilio.isTerminada())
                visitasTerminadas.add(visitaADomicilio);
        }

        return visitasTerminadas;
    }

    public VisitaADomicilio getUltimaVisita() {
        return visitasADomicilio.get(visitasADomicilio.size() - 1);
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

    public SeguimientoDTO toDTO() {
        SeguimientoDTO seguimientoDTO = new SeguimientoDTO();
        seguimientoDTO.setDiasRecordatorio(this.diasRecordatorio);
        seguimientoDTO.setResponsable(this.responsable.toDTO());
        seguimientoDTO.setCadenciaVisita(this.cadenciaVisita);

        List<VisitaDTO> visitasDTO = new ArrayList<>();

        for (VisitaADomicilio visitaADomicilio : visitasADomicilio) {
            visitasDTO.add(visitaADomicilio.toDTO());
        }

        seguimientoDTO.setVisitasADomicilio(visitasDTO);

        return seguimientoDTO;
    }
}