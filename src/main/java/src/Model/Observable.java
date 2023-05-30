package src.Model;

public interface Observable {

    void agregarVeterinario(Observer o);

    void removerVeterinario(Observer o);

    void informarVeterinarios(Alarma alarma);

}
