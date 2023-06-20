package src.DTO;

import src.Enum.Accion;

import java.time.LocalDateTime;
import java.util.List;

public class AlarmaXControlDTO {
    private String idAlarma;

    private LocalDateTime fechaLimite;

    private List<Accion> acciones;

    public AlarmaXControlDTO(String id, LocalDateTime fecha, List<Accion> acciones){
        this.idAlarma = id;
        this.fechaLimite = fecha;
        this.acciones = acciones;
    }

    public String getIdAlarma(){
        return idAlarma;
    }

    public LocalDateTime getFechaLimite(){
        return fechaLimite;
    }

    public List<Accion> getAcciones(){
        return acciones;
    }

    public void mostrarAcciones(){
        for (int i = 0 ; i < acciones.size(); i++) {
            System.out.println("\n Accion: "+acciones.get(i).toString()+ " ");
        }
    }
}
