package src.Controller;

import src.Model.Seguimiento;

import java.util.*;


public class SeguimientoController {

    private List<Seguimiento> seguimientos;

    private SeguimientoController instancia;

    private SeguimientoController() {
        this.seguimientos = new ArrayList<>();
    }

    public SeguimientoController getInstancia() {
        if(this.instancia == null) {
            this.instancia = new SeguimientoController();
        }

        return this.instancia;
    }

    public void enviarRecordatorio() {
        // TODO implement here
    }

}