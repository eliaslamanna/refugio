package src.Controller;

import src.Model.Seguimiento;

import java.util.*;


public class SeguimientoController {

    private List<Seguimiento> seguimientos;

    private static SeguimientoController instancia;

    private SeguimientoController() {
        this.seguimientos = new ArrayList<>();
    }

    public static SeguimientoController getInstancia() {
        if(instancia == null) {
            instancia = new SeguimientoController();
        }

        return instancia;
    }

    public void enviarRecordatorio() {
        // TODO implement here
    }

}