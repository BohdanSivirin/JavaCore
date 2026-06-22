package oop.inheritance.piant;

public class Point implements Cloneable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
               "x=" + x +
               ", y=" + y +
               '}';
    }

    @Override
    public Point clone() {
        return new Point(this.x, this.y);
    }

    public Point fewSteps() {
        x = x + 2;
        y = y + 2;
        return this;
    }
}
