package oop.inheritance.piant;

public final class Rectangle extends Figure {
    private Point first;
    private Point second;
    private Point third;
    private Point fourth;

    public Rectangle(ColourType colourType, LineType lineType, Point leftPoint, Point rightPoint) {
        super(colourType, lineType, leftPoint, rightPoint);
    }

    @Override
    public void draw() {
        first = leftPoint;
        second = rightPoint;
        third = new Point(rightPoint.getX(), leftPoint.getY());
        fourth = new Point(leftPoint.getX(), rightPoint.getY());
        System.out.println(super.toString() + "\n_________\nPoints :\nfirst = " + first + "\nsecond = " + second + "\n third = " + third + "\nfourth = " + fourth);
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(
                this.colourType,
                this.lineType,
                this.leftPoint.clone().fewSteps(),
                this.rightPoint.clone().fewSteps());
    }
}
