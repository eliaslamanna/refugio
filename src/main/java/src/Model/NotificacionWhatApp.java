package src.Model;


public class NotificacionWhatApp implements EstrategiaNotificacion {

    @Override
    public void enviarNotificacion(DatosNotificacion notificacion) {
        System.out.println("WHATSAPP: " + notificacion.getMensaje() + " a " + notificacion.getTelefonoDestino());
    }

}