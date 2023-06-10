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

    private int cadenciaVisita;

    private EstrategiaNotificacion medioNotificacion;

    private Boolean continuarVisitas;

    private int diasRecordatorio;

    private List<VisitaADomicilio> visitasADomicilio = new ArrayList<>();

    private Visitador responsable;


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

// Cuando se crea una nueva adopcion, instaneamente tiene que crearse un seguimiento y una visita.
// El seguimiento va a tener el usuario logueado como responsable y el continuar visita en true.  y los dias recordatorio
// cadencia visita, y medio notificacion seran seteados segun lo que se ingresa por consola.
// La visita se va a crear con una fecha que sea Hoy + cadenciavisita. Y observaciones como una cadena vacia. La
// Encuesta asociada  ala visita, se carga con sus atributos vacios. Para ser completados una vez que se ejecuta la visita.
// Cuando se completa la encuesta una vez de completar la visita, tambien se le pregunta pr consola si hay que seguir
// con las visitas, y en ese momento se setea el continuarVisitas a false si es necesario.