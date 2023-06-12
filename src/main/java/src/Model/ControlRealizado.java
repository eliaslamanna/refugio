package src.Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ControlRealizado {

    private String idControlRealizado;
    private Control control;
    private LocalDateTime fechaEjecucion;

    public ControlRealizado(Control control){
        this.idControlRealizado = UUID.randomUUID().toString();

        this.control = control;

        this.fechaEjecucion = LocalDateTime.now();
    }

    public Control getControl(){
        return control;
    }
}
