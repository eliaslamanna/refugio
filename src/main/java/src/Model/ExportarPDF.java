package src.Model;

import src.DTO.HistoriaClinicaDTO;

public class ExportarPDF implements EstrategiaExportacion {
    public void exportar(HistoriaClinicaDTO historia) {
        System.out.println("EXPORTACION EN PDF");
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
        }
        System.out.println("");
    }
}

