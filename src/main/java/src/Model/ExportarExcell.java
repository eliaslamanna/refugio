package src.Model;

import src.DTO.HistoriaClinicaDTO;

import java.util.Date;

public class ExportarExcell implements EstrategiaExportacion {
    public void exportar(HistoriaClinicaDTO historia) {
        System.out.println("EXPORTACION EN EXCEL");
        for (ControlRealizado control:
             historia.getIntervenciones()) {
            System.out.println("Control:" );
            System.out.println("Fecha: " + control.getControl().getMomentoDeEjecucion().toString());
            System.out.println("Veterinario: " + control.getControl().getVeterinario());
            System.out.println("Acciones:" );
            for (Accion accion:
                 control.getControl().getAcciones()) {
                System.out.println(accion.toString());
            }
            System.out.println("Tratamientos:" );
            for (Tratamiento tratamiento:
                 control.getControl().getTratamientos()) {
                System.out.println("Tratamiento " + tratamiento.getNombre());
                System.out.println("Duaracion: " + tratamiento.getDuracion());
                if (tratamiento.getFinalizado()){
                    System.out .println("Finalizado");
                }else{
                    System.out .println("En tratamiento");
                }
                System.out .println(" ");

            }
            System.out.println("Visitas a domicilio: ");
            Date hoy = new Date();
            for (VisitaADomicilio visita:
                 historia.getVisitasADomicilio().getVisitasADomicilio()) {
                    if (visita.getFechaVisita().before(hoy)){
                        System.out .println("Fecha: " + visita.getFechaVisita().toString());
                        System.out .println("Observaciones: " + visita.getObservaciones());
                        System.out .println("Estado general del animal: " + visita.getEncuesta().getEstado().toString());
                        System.out .println("Estado del ambiente: " + visita.getEncuesta().getAmbiente().toString());
                        System.out .println("Estado de la limpieza : " + visita.getEncuesta().getLimpieza().toString());
                        System.out.println("");
                    }

            }
        }
        System.out.println("");
    }
}
