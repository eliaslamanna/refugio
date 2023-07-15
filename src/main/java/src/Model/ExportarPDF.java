package src.Model;

import src.DTO.ControlPeriodicoDTO;
import src.DTO.HistoriaClinicaDTO;
import src.DTO.TratamientoMedicoDTO;
import src.DTO.VisitaADomicilioDTO;
import src.Enum.Accion;

import java.util.Date;

public class ExportarPDF implements EstrategiaExportacion {
    public void exportar(HistoriaClinicaDTO historia) {
        System.out.println("EXPORTACION EN PDF");
        System.out.println("Nombre: " + historia.getAnimal().getNombre());
        System.out.println("Tipo: " + historia.getAnimal().getTipoAnimal().toString());
        for (ControlPeriodicoDTO controlPeriodicoDTO: historia.getControlesRealizados()){
            System.out.println("Control:");
            System.out.println("Fecha: " + controlPeriodicoDTO.getHoraAtencion().toString());
            System.out.println("Veterinario: " + controlPeriodicoDTO.getAtendidoPor().getNombre());
            System.out.println("Acciones:");
            for (Accion accion :
                    controlPeriodicoDTO.getAcciones()) {
                System.out.println(accion.toString());
            }

        }
        for (TratamientoMedicoDTO tratamientoMedicoDTO: historia.getTratamientosRealizados()){
            System.out.println("Tratamiento:");
            System.out.println("Inicio tratamiento: " + tratamientoMedicoDTO.getInicioTratamiento());
            if (tratamientoMedicoDTO.isEnTratamiento()) {
                System.out.println("Tratamiento En Curso");
            } else {
                System.out.println("Fin tratamiento: " + tratamientoMedicoDTO.getFinTratamiento());
            }
            System.out.println("Fecha: " + tratamientoMedicoDTO.getHoraAtencion().toString());
            System.out.println("Veterinario: " + tratamientoMedicoDTO.getAtendidoPor().getNombre());
            System.out.println("Acciones:");
            for (Accion accion :
                    tratamientoMedicoDTO.getAcciones()) {
                System.out.println(accion.toString());
            }
        }
        if (historia.tieneSeguimientoActivo()) {
            if (historia.getVisitasADomicilio().getVisitasADomicilioTerminadas().size() > 0) {
                System.out.println("Visitas a domicilio: ");
                for (VisitaADomicilioDTO visita : historia.getVisitasADomicilio().getVisitasADomicilioTerminadas()) {
                    if (visita.isTerminada()) {
                        System.out.println("Fecha: " + visita.getFechaVisita().toString());
                        System.out.println("Observaciones: " + visita.getObservaciones());
                        System.out.println("Estado general del animal: " + visita.getEncuesta().getEstado().toString());
                        System.out.println("Estado del ambiente: " + visita.getEncuesta().getAmbiente().toString());
                        System.out.println("Estado de la limpieza : " + visita.getEncuesta().getLimpieza().toString());
                        System.out.println("");
                    }
                }
            }
        }
        System.out.println("");
    }
}
