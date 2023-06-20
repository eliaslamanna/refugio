package src.DTO;

public class DatosNotificacion {

    private String telefonoDestino;

    private String mailDestino;

    private String Mensaje;

    public DatosNotificacion(String telefonoDestino, String mailDestino, String mensaje) {
        this.telefonoDestino = telefonoDestino;
        this.mailDestino = mailDestino;
        Mensaje = mensaje;
    }

    public void setTelefonoDestino(String telefonoDestino) {
        this.telefonoDestino = telefonoDestino;
    }

    public void setMailDestino(String mailDestino) {
        this.mailDestino = mailDestino;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public String getTelefonoDestino() {
        return telefonoDestino;
    }

    public String getMailDestino() {
        return mailDestino;
    }

    public String getMensaje() {
        return Mensaje;
    }

}