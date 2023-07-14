package src.Model;

public class AlarmaAtendida implements EstadoAlarma{
    Alarma alarma;
    Usuario atendidoPor;

    AlarmaAtendida(Alarma alarma, Usuario atendidoPor){
        this.alarma = alarma;
        this.atendidoPor = atendidoPor;
    }
    @Override
    public void atenderAlarma(Alarma alarma, Usuario atendidoPor) {
    }

    @Override
    public boolean isAtendible() {
        return false;
    }
}
