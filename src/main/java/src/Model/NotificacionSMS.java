package src.Model;


public class NotificacionSMS implements EstrategiaNotificacion {

    @Override
    public void enviarNotificacion(DatosNotificacion notificacion) {
        System.out.println("SMS: " + notificacion.getMensaje());
    }

}