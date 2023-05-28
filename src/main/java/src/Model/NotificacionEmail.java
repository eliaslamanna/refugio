package src.Model;


public class NotificacionEmail implements EstrategiaNotificacion {

    @Override
    public void enviarNotificacion(DatosNotificacion notificacion) {
        System.out.println("MAIL: " + notificacion.getMensaje() + " a " + notificacion.getMailDestino());
    }

}