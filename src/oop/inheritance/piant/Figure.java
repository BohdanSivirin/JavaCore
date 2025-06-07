package oop.inheritance.piant;

public abstract class Figure implements Cloneable {
    protected ColourType colourType;
    protected LineType lineType;
    protected Point leftPoint;
    protected Point rightPoint;

    public Figure(ColourType colourType, LineType lineType, Point leftPoint, Point rightPoint) {
        this.colourType = colourType;
        this.lineType = lineType;
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
        draw();
    }

    public abstract void draw();

    public void changeColor(ColourType colourType) {
        this.colourType = colourType;
        draw();
    }

    public void changeDepth(LineType lineType) {
        this.lineType = lineType;
        draw();
    }

    public void move(Point point) {
        rightPoint = new Point(rightPoint.getX() - leftPoint.getX(), rightPoint.getY() - leftPoint.getY());
        leftPoint = point;
        draw();
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }

    @Override
    public String toString() {
        return "\nFigure = " + getClass().getSimpleName()
               + "\ncolourType = " + colourType
               + "\nlineType = " + lineType
               + "\nleftPoint = " + leftPoint
               + "\nrightPoint = " + rightPoint;
    }

    @Override
    public abstract Figure clone();
}
