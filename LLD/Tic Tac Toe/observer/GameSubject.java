package observer;

import java.util.List;
import java.util.ArrayList;
import entities.Game;

public abstract class GameSubject {
    private final List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update((Game) this);
        }
    }
}