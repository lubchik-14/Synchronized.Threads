package point;

import java.util.ArrayList;
import java.util.List;

public class Point implements Observable {
    private List<IPointObserver> observers = new ArrayList<>();
    private static final Object lock = new Object();
    private int x;
    private int y;

    public static void move(Point point, int dx, int dy) {
        synchronized (lock) {
            point.x += dx;
            point.y += dy;
        }
//        notifyObservers();
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
