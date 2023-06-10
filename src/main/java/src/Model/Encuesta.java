package src.Model;

public class Encuesta {

    private EstadoLimpiezaAmbiente estado;

    private EstadoLimpiezaAmbiente limpieza;

    private EstadoLimpiezaAmbiente ambiente;

    public Encuesta(EstadoLimpiezaAmbiente estado, EstadoLimpiezaAmbiente limpieza, EstadoLimpiezaAmbiente ambiente) {
        this.estado = estado;
        this.limpieza = limpieza;
        this.ambiente = ambiente;
    }
}