package src.Model;


import src.DTO.DatosNotificacion;

public class NotificacionEmail implements EstrategiaNotificacion {

    @Override
    public void enviarNotificacion(DatosNotificacion notificacion) {
        System.out.println("MAIL: " + notificacion.getMensaje() + " ||| ENVIADO A: " + notificacion.getMailDestino());
    }

}