package point;

public interface Observable {
    void addObserver(IPointObserver observer);
    void notifyObservers();
}
