package src.Model;


public class Veterinario extends Usuario implements Observer {

    private int nroMatricula;

    @Override
    public void atenderAlarma(Alarma alarma) {
        // como sabemos si finalizo o no para el caso de seguimientoMedico (para el caso del control es siempre true)
        alarma.actualizar(true);
    }

}