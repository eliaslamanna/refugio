package src.Model;


public class Alarma {

    private int periodicidad;

    private Control control;

    public Alarma(int periodicidad, ControlDTO controldto) {
        this.periodicidad = periodicidad;

        Control control = new Control(controldto);
        this.control = control;
        
    }

}