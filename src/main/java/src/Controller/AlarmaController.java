package src.Controller;

import src.Model.Alarma;

import java.util.ArrayList;
import java.util.List;

public class AlarmaController {
    private static AlarmaController instancia;
    private List<Alarma> alarmas;

    private AlarmaController(){
        this.alarmas = new ArrayList<>();
    }

    public static AlarmaController getInstancia() {
        if (instancia == null)
            instancia = new AlarmaController();
        return instancia;
    }

}
