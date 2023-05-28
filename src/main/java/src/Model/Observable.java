package src.Model;

public interface Observable {

    void agregarObserver(Observer o);

    void removerObserver(Observer o);

    void informarObservers();

}
