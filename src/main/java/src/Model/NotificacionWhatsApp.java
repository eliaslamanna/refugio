package src.Model;


import src.DTO.DatosNotificacion;

public class NotificacionWhatsApp implements EstrategiaNotificacion {

    @Override
    public void enviarNotificacion(DatosNotificacion notificacion) {
        System.out.println("WHATSAPP: " + notificacion.getMensaje() + " a " + notificacion.getTelefonoDestino());
    }

}