package src.Model;

public class AlarmaCreada implements EstadoAlarma{
    Alarma alarma;

    AlarmaCreada(Alarma alarma){
        this.alarma = alarma;
    }

    @Override
    public void atenderAlarma(Alarma alarma, Usuario atendidoPor) {
        alarma.setEstadoAlarma(new AlarmaAtendida(alarma, atendidoPor));
    }

    @Override
    public boolean isAtendible() {
        return true;
    }
}
