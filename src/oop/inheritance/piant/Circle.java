package oop.inheritance.piant;

public class Circle extends Figure {
    private Point centre;
    private Point radius;

    public Circle(ColourType colourType, LineType lineType, Point leftPoint, Point rightPoint) {
        super(colourType, lineType, leftPoint, rightPoint);
    }

    @Override
    public void draw() {
        centre = new Point((rightPoint.getX() - leftPoint.getX()) / 2, (rightPoint.getY() - leftPoint.getY()) / 2);
        radius = new Point(leftPoint.getX(), (rightPoint.getY() - leftPoint.getY()) / 2);
        System.out.println(super.toString() + "\n_________\nPoints :\ncentre = " + centre + "\nradius = " + radius);
    }

    @Override
    public Circle clone() {
        return new Circle(
                this.colourType,
                this.lineType,
                this.leftPoint.clone().fewSteps(),
                this.rightPoint.clone().fewSteps());
    }
}
