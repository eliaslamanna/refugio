package src.Model;


public class Alarma {

    private int periodicidad;

    private Control control;

    public Alarma(int periodicidad, Control control) {
        this.periodicidad = periodicidad;
        this.control = control;
    }

}