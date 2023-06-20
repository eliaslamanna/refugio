package src.Model;


import src.DTO.DatosNotificacion;

public interface EstrategiaNotificacion {

    void enviarNotificacion(DatosNotificacion notificacion);

}