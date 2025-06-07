package oop.inheritance.piant;

public class Triangle extends Figure {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(ColourType colourType, LineType lineType, Point leftPoint, Point rightPoint) {
        super(colourType, lineType, leftPoint, rightPoint);
    }

    @Override
    public void draw() {
        first = new Point((rightPoint.getX() - leftPoint.getX()) / 2, leftPoint.getY());
        second = new Point(leftPoint.getX(), rightPoint.getY());
        third = new Point(rightPoint.getX(), rightPoint.getY());
        System.out.println(super.toString() + "\n_________\nPoints :\nfirst = " + first + "\nsecond = " + second + "\nthird = " + third);
    }
    @Override
    public Triangle clone() {
        return new Triangle(
                this.colourType,
                this.lineType,
                this.leftPoint.clone().fewSteps(),
                this.rightPoint.clone().fewSteps());
    }

}
