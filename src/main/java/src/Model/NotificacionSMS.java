package src.Model;


import src.DTO.DatosNotificacion;

public class NotificacionSMS implements EstrategiaNotificacion {

    @Override
    public void enviarNotificacion(DatosNotificacion notificacion) {
        System.out.println("SMS: " + notificacion.getMensaje() + " a " + notificacion.getTelefonoDestino());
    }

}