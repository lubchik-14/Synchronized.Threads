package point;

import java.util.ArrayList;
import java.util.List;

public class Point implements Observable {
    private List<IPointObserver> observers = new ArrayList<>();
    private int x;
    private int y;

    public synchronized void move(int dx, int dy) {
        x += dx;
        y += dy;
        notifyObservers();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void addObserver(IPointObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
