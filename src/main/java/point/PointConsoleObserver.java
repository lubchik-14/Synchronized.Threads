package point;

public class PointConsoleObserver implements IPointObserver {
    @Override
    public void update(Point point) {
        System.out.printf("Point[%s:%s]\n", point.getX(), point.getY());
    }
}
