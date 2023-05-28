package src.Model;

public interface Observerbable {

    void agregarObserver(Observer o);

    void removerObserver(Observer o);

    void informarObservers();

}
