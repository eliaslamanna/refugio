package src.Model;


import src.DTO.VisitaDTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Seguimiento {

    private Usuario Responsable;

    private int cadenciaVisita;

    private EstrategiaNotificacion medioNotificacion;

    private Boolean continuarVisitas;

    private int diasRecordatorio;

    private List<VisitaADomicilio> visitasADomicilio = new ArrayList<>();

    private Usuario responsable;

    private Adopcion adopcion;

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

    public void crearVisita(VisitaDTO visitaDTO) {
        VisitaADomicilio newVisita = new VisitaADomicilio( getProximaFechaDeVisita(getVisitaMasReciente().getFechaVisita()), visitaDTO.getObservaciones(), visitaDTO.getEncuesta());
        this.visitasADomicilio.add(newVisita);
    }

    private Date getProximaFechaDeVisita(Date ultimaVisita){
        Calendar calendario = Calendar.getInstance();

        calendario.setTime(ultimaVisita);

        calendario.add(Calendar.DAY_OF_YEAR, this.cadenciaVisita);

        return calendario.getTime();
    }

}