package src.Model;

import src.DTO.EncuestaDTO;
import src.Enum.EstadoLimpiezaAmbiente;

public class Encuesta {

    private EstadoLimpiezaAmbiente estado;

    private EstadoLimpiezaAmbiente limpieza;

    private EstadoLimpiezaAmbiente ambiente;

    public Encuesta(EstadoLimpiezaAmbiente estado, EstadoLimpiezaAmbiente limpieza, EstadoLimpiezaAmbiente ambiente) {
        this.estado = estado;
        this.limpieza = limpieza;
        this.ambiente = ambiente;
    }

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

    public EncuestaDTO toDTO(){
        EncuestaDTO encuestaDTO = new EncuestaDTO();
        encuestaDTO.setAmbiente(this.ambiente);
        encuestaDTO.setEstado(this.estado);
        encuestaDTO.setLimpieza(this.limpieza);

        return encuestaDTO;
    }
}