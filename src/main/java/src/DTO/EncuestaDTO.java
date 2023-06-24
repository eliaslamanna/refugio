package src.DTO;

import src.Enum.EstadoLimpiezaAmbiente;

public class EncuestaDTO {
    private EstadoLimpiezaAmbiente estado;

    private EstadoLimpiezaAmbiente limpieza;

    private EstadoLimpiezaAmbiente ambiente;

    public EstadoLimpiezaAmbiente getEstado() {
        return estado;
    }

    public EstadoLimpiezaAmbiente getLimpieza() {
        return limpieza;
    }

    public EstadoLimpiezaAmbiente getAmbiente() {
        return ambiente;
    }

    public void setEstado(EstadoLimpiezaAmbiente estado) {
        this.estado = estado;
    }

    public void setLimpieza(EstadoLimpiezaAmbiente limpieza) {
        this.limpieza = limpieza;
    }

    public void setAmbiente(EstadoLimpiezaAmbiente ambiente) {
        this.ambiente = ambiente;
    }
}
