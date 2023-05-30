package src.Model;


import java.util.List;
import java.util.Random;

public abstract class Alarma implements Observable {

    protected int periodicidad;

    // protected Control control; -> cambio anterior

    protected List<Observer> veterinarios;

    protected Animal animal;

    protected List<String> accionesARealizar;

    protected Boolean accionesRealizadas;

    protected Boolean disparada; // -> es el estado, cuando cambia a true se le notifica a los veterinarios

    public Alarma(int periodicidad, Control control, List<Observer> veterinarios, Animal animal, List<String> accionesARealizar) {
        this.periodicidad = periodicidad;
        //this.control = control; -> cambio anterior
        this.veterinarios = veterinarios;
        this.animal = animal;
        this.accionesARealizar = accionesARealizar;
    }

    @Override
    public void agregarVeterinario(Observer o) {
        veterinarios.add(o);
    }

    @Override
    public void removerVeterinario(Observer o) {
        veterinarios.remove(o);
    }

    @Override
    public void informarVeterinarios(Alarma alarma) {
        // solo un veterinario al azar de los que tienen asignados esta alarma va a atenderla
        if(veterinarios.isEmpty()) {
            // TODO throw exception que indique que no hay veterinarios asignados a la alarma
        }

        veterinarios.get(new Random().nextInt(veterinarios.size())).atenderAlarma(alarma);
    }

    public void dispararAlarma() {
        if(disparada) {
            // TODO throw exception que indique que la alarma ya se disparo
        }

        this.disparada = true;
        this.informarVeterinarios(this);
    }

    public void actualizar(Boolean finalizo) {
        this.accionesRealizadas = true;
    }

}