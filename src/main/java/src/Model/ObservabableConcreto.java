package src.Model;

import java.util.ArrayList;
import java.util.List;

public class ObservabableConcreto implements Observable {

    private List<Observer> observers;

    // a
    // b
    // c

    public ObservabableConcreto() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void agregarObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removerObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void informarObservers() {
        observers.forEach(Observer::update);
    }

}
